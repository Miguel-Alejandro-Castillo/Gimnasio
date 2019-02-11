package com.gym.controller;

import com.gym.dao.ActividadRepository;
import com.gym.dao.ClienteRepository;
import com.gym.dao.PagoRepository;
import com.gym.formatter.ActividadEditor;
import com.gym.model.Actividad;
import com.gym.model.Cliente;
import com.gym.model.Pago;
import com.gym.util.NumberUtils;
import com.gym.validator.ClienteValidator;
import com.gym.validator.PagoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private PagoRepository pagoRepository;

    @Autowired
    private PagoValidator pagoValidator;

    @Autowired
    private ActividadEditor actividadEditor;

    @Autowired
    private ClienteValidator clienteBeanValidator;


    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showClientes(){
        ModelAndView mav = new ModelAndView("clientes");
        mav.addObject("clientes", this.clienteRepository.findByBorrado(false));
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
            return new ModelAndView("redirect:/clientes/" + clienteRepository.save(cliente).getId().toString() +"/pagar");
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
        ModelAndView mav = null;
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
    public ModelAndView showPagoForm(@PathVariable(name = "id_cliente") String id_cliente){
        ModelAndView mav=new ModelAndView("pagar");
        Long cliente_id = NumberUtils.toLong(id_cliente);
        Cliente cliente = clienteRepository.findOne(cliente_id);
        mav.addObject("cliente",cliente);
        mav.addObject("pago", new Pago());
        List<Actividad> actividades = actividadRepository.findAll();
        mav.addObject("actividades",actividades);
        return mav;
    }

    @RequestMapping(value="/{id_cliente}/pagarDesdeHome", method = RequestMethod.GET)
    public ModelAndView showPagoFormDesdeHome(@PathVariable(name = "id_cliente") String id_cliente,@RequestParam(name = "idActividad" , defaultValue = "-1", required = false) Long idActividad){
        ModelAndView mav=new ModelAndView("pagar");
        Pago pago = new Pago();
        Actividad actividad = this.actividadRepository.findOne(idActividad);
        if(actividad != null){
            pago.setActividad(actividad);
            pago.setMontoAPagar(actividad.getCosto());
        }
        Long cliente_id = NumberUtils.toLong(id_cliente);
        Cliente cliente = clienteRepository.findOne(cliente_id);
        mav.addObject("cliente",cliente);
        mav.addObject("pago", pago);
        List<Actividad> actividades = actividadRepository.findAll();
        mav.addObject("actividades", actividades);
        return mav;
    }

    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.POST)
    public  ModelAndView submitPago(@PathVariable(name = "id_cliente") String id_cliente, @ModelAttribute("pago") @Valid Pago pago, BindingResult result, RedirectAttributes redirectAttributes){
        ModelAndView mav;
        Long cliente_id = NumberUtils.toLong(id_cliente);
        Cliente cliente = clienteRepository.findOne(cliente_id);
        if(result.hasErrors()) {
            mav= new ModelAndView("pagar");
            List<Actividad> actividades = actividadRepository.findAll();
            mav.addObject("actividades", actividades);
            mav.addObject("cliente",cliente);
        }
        else{
            pago.setMomentoPago(new Date(System.currentTimeMillis()));
            pago.setProfesor(pago.getActividad().getProfesor());
            cliente.getPagos().add(pago);
            clienteRepository.save(cliente);
            redirectAttributes.addFlashAttribute("success_pago", "Se realizo el pago de forma exitosa.");
            mav=new ModelAndView("redirect:/clientes/");
        }
        return mav;

    }

    @RequestMapping(value="/{id_cliente}/pagarDesdeHome", method = RequestMethod.POST)
    public  ModelAndView submitPagoDesdeHome(@PathVariable(name = "id_cliente") String id_cliente, @ModelAttribute("pago") @Valid Pago pago, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()) {
            mav= new ModelAndView("pagar");
            List<Actividad> actividades = actividadRepository.findAll();
            mav.addObject("actividades", actividades);
        }
        else{
            Long cliente_id = NumberUtils.toLong(id_cliente);
            Cliente cliente = clienteRepository.findOne(cliente_id);
            pago.setMomentoPago(new Date(System.currentTimeMillis()));
            pago.setProfesor(pago.getActividad().getProfesor());
            cliente.getPagos().add(pago);
            clienteRepository.save(cliente);
            //redirectAttributes.addFlashAttribute("success_pago", "Se realizo el pago de forma exitosa.");
            mav=new ModelAndView("redirect:/home/");
        }
        return mav;

    }

    @RequestMapping(value="/{idCliente}/delete", method = RequestMethod.DELETE, produces="application/json; charset=UTF-8")
    public  @ResponseBody Boolean delete(@PathVariable(name = "idCliente") Long idCliente){
        Cliente cliente = this.clienteRepository.findOne(idCliente);
        if(cliente != null){
            cliente.setBorrado(true);
            this.clienteRepository.save(cliente);
            return true;
        }
        else
            return false;
    }

    @RequestMapping(value="/{idCliente}/delete_pago/{idPago}", method = RequestMethod.DELETE, produces="application/json; charset=UTF-8")
    public  @ResponseBody Boolean deletePago(@PathVariable(name = "idCliente") Long idCliente, @PathVariable(name = "idPago")  Long idPago ){
        Cliente cliente = this.clienteRepository.findOne(idCliente);
        if(cliente != null){
            boolean isBorrado =  cliente.getPagos().removeIf(pago -> pago.getId().equals(idPago));
            this.clienteRepository.save(cliente);
            return isBorrado;
        }
        else
            return false;
    }

    @RequestMapping(value="/{id_cliente}/clienteDetalle/{id_pago}", method = RequestMethod.GET)
    public ModelAndView showDetallePago(@PathVariable(name = "id_pago") String id_pago,@PathVariable(name = "id_cliente") String id_cliente){
        ModelAndView mav = null;
        
        Long id_cli = NumberUtils.toLong(id_cliente);
        Long id_pa = NumberUtils.toLong(id_pago);
        Cliente cliente= clienteRepository.findOne(id_cli);
        Pago pago = pagoRepository.findOne(id_pa);
        if(pago != null) {
            mav= new ModelAndView("pagoDetalle");
            mav.addObject("pago", pago);
            mav.addObject("cliente",cliente);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de cliente en el path
        }
        return mav;
    }

    @RequestMapping(value="/{idCliente}/completarPago/{idPago}", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
    public  @ResponseBody boolean completarPago(@PathVariable(name = "idCliente") Long idCliente, @PathVariable(name = "idPago")  Long idPago){

        Pago pago = this.clienteRepository.findPagoByIdClienteAndIdPago(idCliente, idPago);
        if(pago != null){
           pago.setMontoPagado(pago.getMontoAPagar());
           this.pagoRepository.save(pago);
           return true;
        }
        else
            return false;
    }

    @RequestMapping(value="/{idCliente}/getMontoAPagar/{idPago}", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
    public  @ResponseBody BigDecimal getMontoAPagar(@PathVariable(name = "idCliente") Long idCliente, @PathVariable(name = "idPago")  Long idPago){
        return this.clienteRepository.findMontoAPagarByIdPago(idCliente, idPago);
    }
    
    @InitBinder("cliente")
    protected void initBinderCliente(WebDataBinder binder) {
        binder.addValidators(clienteBeanValidator);
    }

    @InitBinder("pago")
    protected void initBinderPago(WebDataBinder binder) {
        binder.addValidators(pagoValidator);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Actividad.class, this.actividadEditor);
    }

}
