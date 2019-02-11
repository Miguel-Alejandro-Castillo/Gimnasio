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

import javax.jws.WebParam;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
        /*
        for (Producto producto: productos
             ) {
            int s;
            List<Stock> ultimoStock = stockRepository.obtenerUltimoStock(producto.getId());
            if(ultimoStock != null){
                if(ultimoStock.isEmpty()){
                    s = 0;
                }else{
                    s = ultimoStock.get(0).getStockAnterior() + ultimoStock.get(0).getCantidadRecibida() - stockRepository.vendidosDesdeElUltimoStock(producto.getId());
                }
                producto.setStockActual(s);
            }
        }
        */
        mav.addObject("productos", productos);//que muestro solo los que no esta borrados
        return mav;
    }

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public ModelAndView listarStocks(){
        ModelAndView mav = new ModelAndView("stocks");
        List<Stock> stocks = this.stockRepository.findAll();
        mav.addObject("stocks", stocks);
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

    @RequestMapping(value = "/registrarStock",method = RequestMethod.POST)
    public ModelAndView submitStock(@ModelAttribute("stock") @Validated Stock stock, BindingResult result){
        ModelAndView mav;
        Producto producto = productoRepository.findOne(stock.getProducto().getId());
        stock.setProducto(producto);
        stock.setFechaIngreso(new Date());
        /*
        List<Stock> ultimoStock = this.stockRepository.obtenerUltimoStock(stock.getProducto().getId());
        if(!ultimoStock.isEmpty()){
            stock.setStockAnterior(ultimoStock.get(0).getStockAnterior()
                    + ultimoStock.get(0).getCantidadRecibida()- this.stockRepository.vendidosDesdeElUltimoStock(stock.getProducto().getId()));
        }else{
            stock.setStockAnterior(0);
        }
        */
        this.stockRepository.save(stock);
        mav = new ModelAndView("redirect:/productos");
        return mav;
    }

    @RequestMapping(value="/{idStock}/stockDelete", method = RequestMethod.DELETE,  produces="application/json; charset=UTF-8")
    public @ResponseBody
    Response deleteStock(@PathVariable(name = "idStock") Long idStock){
        Boolean isDelete = false;
        Stock stock = this.stockRepository.findOne(idStock);
        if(stock != null){
            this.stockRepository.delete(stock.getId());
            isDelete = true;
        }
        return new Response(isDelete);
    }

    @RequestMapping(value="/{idVenta}/deleteVenta", method = RequestMethod.DELETE,  produces="application/json; charset=UTF-8")
    public  @ResponseBody
    Response deleteVenta(@PathVariable(name = "idVenta") Long idVenta){
        Boolean isDelete = false;
        Venta venta = this.ventaRepository.findOne(idVenta);
        if(venta != null){
            this.ventaRepository.delete(venta.getId());
            isDelete = true;
        }
        return new Response(isDelete);
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

    @RequestMapping(value = "/{id_producto}/editar",method = RequestMethod.GET)
    public ModelAndView showModificarProducto(@PathVariable("id_producto") String idProducto){
        ModelAndView mav = new ModelAndView("editar-producto");
        Long id = NumberUtils.toLong(idProducto);
        Producto producto = this.productoRepository.findOne(Long.valueOf(idProducto));
        if (producto != null){
            mav.addObject("producto",producto);
        }else{

        }
        return mav;

    }

    @RequestMapping(value="/{idProducto}/venta", method = RequestMethod.POST,  produces="application/json; charset=UTF-8")
    public  @ResponseBody
    Response venta(@PathVariable(name = "idProducto") Long idProducto){
        Boolean success = false;
        Producto producto = this.productoRepository.findOne(idProducto);
        /*
        List<Stock> ultimoStock = this.stockRepository.obtenerUltimoStock(idProducto);
        if (!ultimoStock.isEmpty()){
            Integer cantActual = ultimoStock.get(0).getStockAnterior()
                    - this.stockRepository.vendidosDesdeElUltimoStock(producto.getId());
            if (cantActual <= 0){
                return new Response(success);
            }
        }
        */
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
            Set<Stock> stocksCorrespondientes = producto.getStocks();
            this.productoRepository.save(producto);

            for (Stock stock : stocksCorrespondientes
                 ) {this.stockRepository.delete(stock.getId());
            }
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

    @RequestMapping(value = "/{id_producto}/detalle",method = RequestMethod.GET)
    public ModelAndView showDetalle(@PathVariable("id_producto") String id_producto){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_producto);
        Producto producto = productoRepository.findOne(id);
        if(producto != null){
            mav = new ModelAndView("detalle-producto");
            /*
           List<Stock> ultimoStock = stockRepository.obtenerUltimoStock(producto.getId());
            Integer s;
            if(!ultimoStock.isEmpty()){
                s = ultimoStock.get(0).getCantidadRecibida() - stockRepository.vendidosDesdeElUltimoStock(producto.getId());
            } else {
              s = 0;
            }
            mav.addObject("cantidadActual",s);

            */
            List<Venta> ventas = ventaRepository.obtenerUltimasVentas(id);
            List<Stock> stocks = stockRepository.obtenerStocks(id);
            mav.addObject("stocks",stocks);
            mav.addObject("ventas",ventas);
            mav.addObject("producto",producto);
        }else{
            //renderizar error
        }
        return mav;
    }

}
