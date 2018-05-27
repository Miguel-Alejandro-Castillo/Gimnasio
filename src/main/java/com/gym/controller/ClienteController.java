package com.gym.controller;

import com.gym.bean.ClienteBean;
import com.gym.bean.PagoBean;
import com.gym.dao.ActividadRepository;
import com.gym.dao.ClienteRepository;
import com.gym.model.Actividad;
import com.gym.model.Cliente;
import com.gym.model.Pago;
import com.gym.util.NumberUtils;
import com.gym.validator.PagoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showClientes(){
        ModelAndView mav=new ModelAndView("clientes");
        List<Cliente> clientes= clienteRepository.findAll();
        mav.addObject("clientes",clientes);
        return mav;
    }

    @RequestMapping(value="/crear", method = RequestMethod.GET)
    public ModelAndView showAltaClienteForm(){
        ModelAndView mav=new ModelAndView("crear-cliente");
        mav.addObject("clienteBean", new ClienteBean());
        return mav;
    }

    @RequestMapping(value="/crear", method = RequestMethod.POST)
    public  ModelAndView submitCreateCliente(@ModelAttribute("clienteBean") @Validated ClienteBean clienteBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("crear-cliente");
        else{
            Cliente cliente=new Cliente(clienteBean);
            clienteRepository.save(cliente);
            return new ModelAndView("redirect:/clientes");
        }

    }

    @RequestMapping(value="/{id_cliente}/clienteDetalle", method = RequestMethod.GET)
    public ModelAndView showDetalleCliente(@PathVariable(name = "id_cliente") String id_cliente){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_cliente);
        Cliente cliente= clienteRepository.findOne(id);
        if(cliente!=null) {
            ClienteBean clienteBean = new ClienteBean(cliente);
            mav= new ModelAndView("detalle-cliente");
            mav.addObject("clienteBean", clienteBean);
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
            ClienteBean clienteBean = new ClienteBean(cliente);
            mav= new ModelAndView("editar-cliente");
            mav.addObject("clienteBean", clienteBean);
            
        }
        else {
            // renderizar a una vista que informe que no se envio un id de cliente en el path
        }
        return mav;
    }
    
    
    @RequestMapping(value="/{id_cliente}/clienteEditar", method = RequestMethod.POST)
    public  ModelAndView submitEditCliente(@PathVariable(name = "id_cliente") String id_cliente, @ModelAttribute("clienteBean") @Validated ClienteBean clienteBean, BindingResult result){
        if(result.hasErrors()) {
            return new ModelAndView("editar-cliente");
        }
        else{
            Long clienteId = NumberUtils.toLong(id_cliente);
            Cliente  cliente = clienteRepository.findOne(clienteId);
            cliente.setApellido(clienteBean.getApellido());
            cliente.setNombre(clienteBean.getNombre());
            cliente.setFecha_de_nacimiento(clienteBean.getFecha_de_nacimiento());
            cliente.setDireccion(clienteBean.getDireccion());
            cliente.setDni(clienteBean.getDni());
            cliente.setEmail(clienteBean.getEmail());
            cliente.setTelefono(clienteBean.getTelefono());
            clienteRepository.save(cliente);
            return new ModelAndView("redirect:/clientes");
        }

    }

    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.GET)
    public ModelAndView showPagoForm(){
        ModelAndView mav=new ModelAndView("pagar");
        mav.addObject("pagoBean", new PagoBean());
        List<Actividad> actividades = actividadRepository.findAll();
        mav.addObject("actividades",actividades);
        return mav;
    }

    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.POST)
    public  ModelAndView submitPago(@PathVariable(name = "id_cliente") String id_cliente, @ModelAttribute("pagoBean") @Validated PagoBean pagoBean, BindingResult result, RedirectAttributes redirectAttributes){
        ModelAndView mav;
        if(result.hasErrors()) {
            mav= new ModelAndView("pagar");
            List<Actividad> actividades= actividadRepository.findAll();
            mav.addObject("actividades",actividades);
        }
        else{
            Actividad actividad = actividadRepository.findOne(pagoBean.getActividad_id());
            Pago pago=new Pago(pagoBean.getId(),actividad,pagoBean.getMonto(),pagoBean.getFecha_hasta(), pagoBean.getFecha_desde());
            Long cliente_id = NumberUtils.toLong(id_cliente);
            Cliente cliente = clienteRepository.findOne(cliente_id);
            cliente.getPagos().add(pago);
            clienteRepository.save(cliente);
            redirectAttributes.addFlashAttribute("success_pago", "Se realizo el pago de forma exitosa.");
            mav=new ModelAndView("redirect:/clientes/");
        }
        return mav;

    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(pagoValidator);
    }

}
