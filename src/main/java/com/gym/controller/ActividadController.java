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

import com.gym.bean.ActividadBean;

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


}
