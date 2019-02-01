package com.gym.controller;

import com.gym.dao.ProductoRepository;
import com.gym.dao.StockRepository;
import com.gym.dao.VentaRepository;
import com.gym.model.Producto;
import com.gym.model.Stock;
import com.gym.model.Venta;
import com.gym.util.NumberUtils;
import com.gym.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @RequestMapping(value={"", "/"},method = RequestMethod.GET)
    public ModelAndView listarProductos(){
        ModelAndView mav = new ModelAndView("productos");
        List<Producto> productos = this.productoRepository.findByBorradoIsFalse();
        for (Producto producto: productos
             ) {
            int s;
            if(stockRepository.obtenerUltimoStock(producto.getId()).isEmpty()){
                s = 0;
            }else{
                s = stockRepository.obtenerUltimoStock(producto.getId()).get(0).getCantidadActual();
            }
            producto.setStockActual(s);

        }
        mav.addObject("productos", this.productoRepository.findByBorradoIsFalse());//que muestro solo los que no esta borrados
        return mav;
    }

    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public ModelAndView showCrearProducto(){
        ModelAndView mav = new ModelAndView("crear-producto");
        mav.addObject("producto",new Producto());
        return mav;
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ModelAndView submitCrearProducto(@ModelAttribute("producto") @Validated Producto producto, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()){
            mav = new ModelAndView("crear-producto");
        }else {
            this.productoRepository.save(producto);
            mav = new ModelAndView("redirect:/productos");
        }
        return mav;
    }

    @RequestMapping(value = "/{id_producto}/registrarStock",method = RequestMethod.POST)
    public ModelAndView submitStock(@ModelAttribute("stock") @Validated Stock stock,
                                    @PathVariable("id_producto") String id_producto,
                                    BindingResult result){
        ModelAndView mav;
        Long id = NumberUtils.toLong(id_producto);
        Producto producto = productoRepository.findOne(id);
        if(result.hasErrors()){
            mav = new ModelAndView("crear-stock");
        }else {
            Stock ultimoStock;
            if (this.stockRepository.obtenerUltimoStock(producto.getId()).isEmpty()){
                ultimoStock = new Stock();
                ultimoStock.setCantidadActual(0);
                ultimoStock.setCantidadRecibida(0);
            }else{
                ultimoStock = this.stockRepository.obtenerUltimoStock(producto.getId()).get(0);
            }
            stock.setCantidadActual(ultimoStock.getCantidadActual()+stock.getCantidadRecibida());
            stock.setProducto(producto);
            stock.setFechaIngreso(new Date());
            this.stockRepository.save(stock);
            mav = new ModelAndView("redirect:/productos");
        }
        return mav;
    }

    @RequestMapping(value = "/registrarStock", method = RequestMethod.DELETE)
    public ModelAndView deleteStock(@PathVariable("id_stock") String id_stock,BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()){
            mav = new ModelAndView("/productos");
        }else {
            this.stockRepository.delete(Long.valueOf(id_stock));
            mav = new ModelAndView("/productos");
        }
        return mav;
    }

    @RequestMapping(value = "/{id_producto}/registrarStock",method = RequestMethod.GET)
    public ModelAndView showCrearStock(@PathVariable("id_producto") String id_producto){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_producto);
        Producto producto = productoRepository.findOne(id);
        if(producto != null){
            mav = new ModelAndView("crear-stock");
            Stock stock = new Stock();
            stock.setProducto(producto);
            mav.addObject(stock);
        }else{
            //renderizar error
        }
        return mav;
    }


    @RequestMapping(value = "/{id_producto}/editar",method = RequestMethod.POST)
    public ModelAndView submitModificarProducto(@PathVariable("id_producto") String id_producto, @ModelAttribute("producto") @Validated Producto producto, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()){
            mav = new ModelAndView("editar-producto");
        }else{
            productoRepository.save(producto);
            mav = new ModelAndView("redirect:/productos/");
        }
        return mav;
    }


    @RequestMapping(value="/{idProducto}/venta", method = RequestMethod.POST,  produces="application/json; charset=UTF-8")
    public  @ResponseBody
    Response venta(@PathVariable(name = "idProducto") Long idProducto){
        Boolean success = false;
        Producto producto = this.productoRepository.findOne(idProducto);

        Stock ultimoStock = this.stockRepository.obtenerUltimoStock(idProducto).get(0);
        if (ultimoStock.getCantidadActual() <= 0){
            return new Response(success);
        }

        ultimoStock.setCantidadActual(ultimoStock.getCantidadActual()-1);
        this.stockRepository.save(ultimoStock);
        if(producto != null){
            ventaRepository.save(new Venta(producto, producto.getCosto()));
            success = true;
        }
        return new Response(success);
    }

    @RequestMapping(value="/{idProducto}/delete", method = RequestMethod.DELETE,  produces="application/json; charset=UTF-8")
    public  @ResponseBody
    Response delete(@PathVariable(name = "idProducto") Long idProducto){
        Boolean isDelete = false;
        Producto producto = this.productoRepository.findOne(idProducto);
        if(producto != null){
            producto.setBorrado(true);
            this.productoRepository.save(producto);
            isDelete = true;
        }
        return new Response(isDelete);
    }

    @RequestMapping( value = "/productosVentas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ModelAndView cargarListadoProductos(@RequestParam(name = "mes", required = false) Integer mes, @RequestParam(name = "anio", required = false) Integer anio ) {
        ModelAndView mav = new ModelAndView("productosVentas");
        mav.addObject("productos", this.productoRepository.listadoProductosVentas(mes, anio));
        List<Integer> anios = this.ventaRepository.aniosConAlMenosUnaVenta();
        mav.addObject("anios", anios);
        return mav;
    }

}
