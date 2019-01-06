package com.gym.controller;

import com.gym.dao.ProductoRepository;
import com.gym.dao.VentaRepository;
import com.gym.model.Producto;
import com.gym.util.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView listarProductos(){
        ModelAndView mav = new ModelAndView("productos");
        mav.addObject("productos",productoRepository.findAll());//que muestro solo los que no esta borrados
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
            productoRepository.save(producto);
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
    public ModelAndView submitModificarProducto(@PathVariable("id_producto") String id_producto){
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



}
