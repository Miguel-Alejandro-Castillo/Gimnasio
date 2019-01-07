package com.gym.controller;

import com.gym.dao.ProductoRepository;
import com.gym.dao.VentaRepository;
import com.gym.dto.ProductoVentaDTO;
import com.gym.model.Producto;
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

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @RequestMapping(value={"", "/"},method = RequestMethod.GET)
    public ModelAndView listarProductos(){
        ModelAndView mav = new ModelAndView("productos");
        mav.addObject("productos", this.productoRepository.listadoProductosVentas(null, null));//que muestro solo los que no esta borrados
        List<Integer> anios = this.ventaRepository.aniosConAlMenosUnaVenta();
        mav.addObject("anios", anios);
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

    /*
    public ModelAndView removerProducto(){
       editar modelo para que reciba borrado logico
       copypastear los metodos de Cliente para esto
    }
    */

    @RequestMapping(value = "/{id_producto}/editar",method = RequestMethod.GET)
    public ModelAndView showModificarProducto(@PathVariable("id_producto") String id_producto){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_producto);
        Producto producto = productoRepository.findOne(id);
        if(producto != null){
            mav = new ModelAndView("editar-producto");
            mav.addObject(producto);
        }else{
            //renderizar error
        }
        return mav;
    }

    @RequestMapping(value = "/{id_producto/editar}",method = RequestMethod.POST)
    public ModelAndView submitModificarProducto(@PathVariable("id_producto") String id_producto, @ModelAttribute("producto") @Validated Producto producto, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()){
            mav = new ModelAndView("editar-producto");
        }else{
            productoRepository.save(producto);
            mav = new ModelAndView("redirect:/productos");
        }
        return mav;
    }

    @RequestMapping(value = "/{id_producto}/venta",method = RequestMethod.POST)
    public ModelAndView submitVenta(@PathVariable("id_producto") String id_producto, @ModelAttribute("producto")@Validated Producto producto, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()){
            mav = new ModelAndView("productos");
        }else{
            ventaRepository.save(new Venta(producto, producto.getCosto()));
            mav = new ModelAndView("redirect:/productos");
        }
        return mav;
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

    @RequestMapping( value = "/listadoProductosVentas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ModelAndView cargarListadoProductos(@RequestParam(name = "mes", required = false) Integer mes, @RequestParam(name = "anio", required = false) Integer anio ) {
        ModelAndView mav = new ModelAndView("productos");
        mav.addObject("productos", this.productoRepository.listadoProductosVentas(mes, anio));//que muestro solo los que no esta borrados
        List<Integer> anios = this.ventaRepository.aniosConAlMenosUnaVenta();
        mav.addObject("anios", anios);
        return mav;
    }

}
