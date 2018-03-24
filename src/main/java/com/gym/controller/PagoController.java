package com.gym.controller;

import com.gym.bean.HorarioBean;
import com.gym.bean.PagoBean;
import com.gym.bean.ActividadBean;
import com.gym.dao.ActividadRepository;
import com.gym.dao.PagoRepository;
import com.gym.model.Pago;
import com.gym.model.Actividad;
import com.gym.util.NumberUtils;

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
    
    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.GET)
    public ModelAndView showPagoForm(){
        ModelAndView mav=new ModelAndView("pagar");
        mav.addObject("pagoBean", new PagoBean());
        List<Actividad> actividades= actividadRepository.findAll();
        mav.addObject("actividades",actividades);
        return mav;
    }
    
    @RequestMapping(value="/{id_cliente}/pagar", method = RequestMethod.POST)
    public  ModelAndView submitPago(@ModelAttribute("pagoBean") @Validated PagoBean pagoBean, BindingResult result){
    	if(result.hasErrors())
            return new ModelAndView("pagar");
        else{
	        Pago pago=new Pago(pagoBean.getId(),pagoBean.getActividad(),pagoBean.getMonto(),pagoBean.getFecha_hasta(), pagoBean.getFecha_desde());
	        pagoRepository.save(pago);
	        return new ModelAndView("redirect:/pagar");
        }

    }

}
