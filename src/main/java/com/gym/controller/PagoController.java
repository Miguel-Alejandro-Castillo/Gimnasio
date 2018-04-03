package com.gym.controller;

import com.gym.bean.HorarioBean;
import com.gym.bean.PagoBean;
import com.gym.bean.ActividadBean;
import com.gym.dao.ActividadRepository;
import com.gym.dao.PagoRepository;
import com.gym.model.Pago;
import com.gym.model.Actividad;
import com.gym.model.Cliente;
import com.gym.util.NumberUtils;
import com.gym.dao.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.Calendar;
import java.util.List;


@Controller
@RequestMapping(value="/pagar")
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;
    
    @Autowired
    private ActividadRepository actividadRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.GET)
    public ModelAndView showPagoForm(){
        ModelAndView mav=new ModelAndView("pagar");
        mav.addObject("pagoBean", new PagoBean());
        List<Actividad> actividades= actividadRepository.findAll();
        mav.addObject("actividades",actividades);
        return mav;
    }
    
    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.POST)
    public  ModelAndView submitPago(@PathVariable(name = "id_cliente") String id_cliente, @ModelAttribute("pagoBean") @Validated PagoBean pagoBean, BindingResult result){
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

	        mav=new ModelAndView("redirect:/clientes/{id_cliente}/editar");
        }
        return mav;

    }

}
