package com.gym.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gym.dao.ActividadRepository;
import com.gym.dao.CobroRepository;
import com.gym.dao.HorarioRepository;
import com.gym.dao.ProfesorRepository;
import com.gym.model.Actividad;
import com.gym.model.Cliente;
import com.gym.model.Cobro;
import com.gym.model.Pago;
import com.gym.util.NumberUtils;

@Controller
@RequestMapping(value="/cobros")
public class CobroController {

	@Autowired
    private ActividadRepository actividadRepository;
    
    @Autowired
	private CobroRepository cobroRepository;
    
    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showCobros(){
        ModelAndView mav=new ModelAndView("cobros");
        List<Cobro> cobros= cobroRepository.findAll();
        mav.addObject("cobros",cobros);
        return mav;
    }
    
    @RequestMapping(value="/realizar", method = RequestMethod.GET)
    public ModelAndView showCobroForm(){
        ModelAndView mav = new ModelAndView("cobro");
        mav.addObject("cobro", new Cobro());
        List<Actividad> actividades = actividadRepository.findAll();
        mav.addObject("actividades",actividades);
        return mav;
    }

    @RequestMapping(value="/realizar", method = RequestMethod.POST)
    public  ModelAndView submitRealizarCobro(@ModelAttribute("cobro") @Validated Cobro cobro, BindingResult result){
        
    	ModelAndView mav;
    	if(result.hasErrors()) {
        	mav = new ModelAndView("cobro");
            mav.addObject("cobro", new Cobro());
            List<Actividad> actividades = actividadRepository.findAll();
            mav.addObject("actividades",actividades);
        }
        else{
        	cobro.setMomentoCobro(new Date(System.currentTimeMillis()));
        	if(!(cobro.getActividad().getId() == null)){
	        	Actividad actividad = actividadRepository.findOne(cobro.getActividad().getId());
	        	cobro.setActividad(actividad);	
        	}else {
        		cobro.setActividad(null);
        	}
            cobroRepository.save(cobro);
            return new ModelAndView("redirect:/cobros");
            
        }
    	return mav;
    }
    
}
