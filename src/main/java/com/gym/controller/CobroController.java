package com.gym.controller;

import java.util.Date;
import java.util.List;
import com.gym.formatter.ActividadEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.gym.dao.ActividadRepository;
import com.gym.dao.CobroRepository;
import com.gym.model.Actividad;
import com.gym.model.Cobro;

@Controller
@RequestMapping(value="/cobros")
public class CobroController {

	@Autowired
    private ActividadRepository actividadRepository;
   
    @Autowired
	private CobroRepository cobroRepository;

    @Autowired
    private ActividadEditor actividadEditor;
    
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
    public ModelAndView submitRealizarCobro(@ModelAttribute("cobro") @Validated Cobro cobro, BindingResult result){
        
    	ModelAndView mav = new ModelAndView("cobro");
    	if(result.hasErrors()) {
            List<Actividad> actividades = actividadRepository.findAll();
            mav.addObject("actividades",actividades);
                          
        }
        else{
        	cobro.setMomentoCobro(new Date(System.currentTimeMillis()));
            cobro.setProfesor(cobro.getActividad().getProfesor());
            cobroRepository.save(cobro);
            return new ModelAndView("redirect:/cobros");
        }
    	return mav;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Actividad.class, this.actividadEditor);
    }
    
}
