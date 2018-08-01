package com.gym.controller;

import com.gym.dao.ActividadRepository;
import com.gym.dao.ClienteRepository;
import com.gym.formatter.ActividadEditor;
//import com.gym.formatter.ActividadEditor;
import com.gym.model.Actividad;
import com.gym.model.Cliente;
import com.gym.model.Pago;
import com.gym.util.NumberUtils;
import com.gym.validator.ClienteValidator;
import com.gym.validator.PagoValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

/**
 * Created by Alejandro on 12/2/2018.
 */
@Controller
@RequestMapping(value="/clientes")
public class ClienteController {

    @Autowired	
    private ClienteRepository clienteRepository;

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private PagoValidator pagoValidator;

    @Autowired
    private ActividadEditor actividadEditor;

    @Autowired
    private ClienteValidator clienteBeanValidator;


    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showClientes(){
        ModelAndView mav = new ModelAndView("clientes");
        List<Cliente> clientes = clienteRepository.findAll();
        mav.addObject("clientes", clientes);
        return mav;
    }

    @RequestMapping(value="/crear", method = RequestMethod.GET)
    public ModelAndView showAltaClienteForm(){
        ModelAndView mav = new ModelAndView("crear-cliente");
        mav.addObject("cliente", new Cliente());
        return mav;
    }

    @RequestMapping(value="/crear", method = RequestMethod.POST)
    public  ModelAndView submitCreateCliente(@ModelAttribute("cliente") @Validated Cliente cliente, BindingResult result){
        if(result.hasErrors()) {
            return new ModelAndView("crear-cliente");
        }
        else{
            clienteRepository.save(cliente);
            return new ModelAndView("redirect:/clientes");
        }
    }

    @RequestMapping(value="/{id_cliente}/clienteDetalle", method = RequestMethod.GET)
    public ModelAndView showDetalleCliente(@PathVariable(name = "id_cliente") String id_cliente){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_cliente);
        Cliente cliente= clienteRepository.findOne(id);
        if(cliente != null) {
            mav= new ModelAndView("detalle-cliente");
            mav.addObject("cliente", cliente);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de cliente en el path
        }
        return mav;
    }
    
    @RequestMapping(value="/{id_cliente}/clienteEditar", method = RequestMethod.GET)
    public ModelAndView showEditarClienteForm(@PathVariable(name = "id_cliente") String id_cliente){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_cliente);
        Cliente cliente= clienteRepository.findOne(id);
        if(cliente!=null) {
            mav= new ModelAndView("editar-cliente");
            mav.addObject("cliente", cliente);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de cliente en el path
        }
        return mav;
    }
    
    
    @RequestMapping(value="/{id_cliente}/clienteEditar", method = RequestMethod.POST)
    public  ModelAndView submitEditCliente(@PathVariable(name = "id_cliente") String id_cliente, @ModelAttribute("cliente") @Validated Cliente cliente, BindingResult result){
        if(result.hasErrors()) {
            return new ModelAndView("editar-cliente");
        }
        else{
            clienteRepository.save(cliente);
            return new ModelAndView("redirect:/clientes");
        }

    }

    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.GET)
    public ModelAndView showPagoForm(){
        ModelAndView mav=new ModelAndView("pagar");
        mav.addObject("pago", new Pago());
        List<Actividad> actividades = actividadRepository.findAll();
        mav.addObject("actividades",actividades);
        return mav;
    }

    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.POST)
    public  ModelAndView submitPago(@PathVariable(name = "id_cliente") String id_cliente, @ModelAttribute("pago") @Valid Pago pago, BindingResult result, RedirectAttributes redirectAttributes){
        
        
        pagoValidator.validate(pago, result);
        ModelAndView mav;
        if(result.hasErrors()) {
            mav= new ModelAndView("pagar");
            List<Actividad> actividades = actividadRepository.findAll();
            mav.addObject("actividades",actividades);
        }
        else{
            Long cliente_id = NumberUtils.toLong(id_cliente);
            Cliente cliente = clienteRepository.findOne(cliente_id);
            pago.setMomentoPago(new Date(System.currentTimeMillis()));
            Actividad actividad = actividadRepository.findOne(pago.getActividad().getId());
            pago.setActividad(actividad);
            cliente.getPagos().add(pago);
            clienteRepository.save(cliente);
            redirectAttributes.addFlashAttribute("success_pago", "Se realizo el pago de forma exitosa.");
            mav=new ModelAndView("redirect:/clientes/");
        }
        return mav;

    }

    @InitBinder("cliente")
    protected void initBinderCliente(WebDataBinder binder) {
        binder.addValidators(clienteBeanValidator);
    }
/*
    @InitBinder("pago")
    protected void initBinderPago(WebDataBinder binder) {
        binder.addValidators(pagoValidator);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Actividad.class, this.actividadEditor);
    }

*/


}
