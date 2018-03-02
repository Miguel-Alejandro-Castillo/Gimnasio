package com.gym.controller;

import com.gym.bean.ActividadBean;
import com.gym.dao.ActividadRepository;
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
import java.util.List;

/**
 * Created by tuPaPá on 12/2/2018.
 */
@Controller
@RequestMapping(value="/actividades")
public class ActividadController {

    @Autowired
    private ActividadRepository actividadRepository;

    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showActividades(){
        ModelAndView mav=new ModelAndView("actividades");
        List<Actividad> actividades= actividadRepository.findAll();
        mav.addObject("actividades",actividades);
        return mav;
    }
    
    @RequestMapping(value="/crearActividad", method = RequestMethod.GET)
    public ModelAndView showAltaActividadForm(){
        ModelAndView mav=new ModelAndView("crear-actividad");
        mav.addObject("actividadBean", new ActividadBean());
        return mav;
    }

    @RequestMapping(value="/crearActividad", method = RequestMethod.POST)
    public  ModelAndView submitCreateActividad(@ModelAttribute("actividadBean") @Validated ActividadBean actividadBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("crear-actividad");
        else{
            Actividad actividad=new Actividad(actividadBean.getId(), actividadBean.getNombreActividad(), actividadBean.getProfesor(), actividadBean.getCosto(), actividadBean.getDia());
            actividadRepository.save(actividad);
            return new ModelAndView("redirect:/actividades");
        }

    }

    @RequestMapping(value="/{id_actividad}/editar", method = RequestMethod.GET)
    public ModelAndView showEditarActividadForm(@PathVariable(name = "id_actividad") String id_actividad){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_actividad);
        Actividad actividad= actividadRepository.findOne(id);
        if(actividad!=null) {
            ActividadBean actividadBean = new ActividadBean();
            actividadBean.load(actividad);
            mav= new ModelAndView("editar-actividad");
            mav.addObject("actividadBean", actividad);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de actividad en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_actividad}/editar", method = RequestMethod.POST)
    public  ModelAndView submitEditActividad(@ModelAttribute("actividadBean") @Validated ActividadBean actividadBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("editar-actividad");
        else{
        	Actividad actividad=new Actividad(actividadBean.getId(), actividadBean.getNombreActividad(), actividadBean.getProfesor(), actividadBean.getCosto(), actividadBean.getDia());
            actividadRepository.save(actividad);
            return new ModelAndView("redirect:/actividades");
        }

    }




}
