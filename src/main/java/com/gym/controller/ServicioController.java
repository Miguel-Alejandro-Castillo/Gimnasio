package com.gym.controller;


import com.gym.bean.ServicioBean;
import com.gym.dao.ServicioRepository;
import com.gym.model.Servicio;
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

import com.gym.bean.ServicioBean;


/**
 * Created by tuPaPá on 12/2/2018.
 */
@Controller
@RequestMapping(value="/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository ServicioRepository;

    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showServicios(){
        ModelAndView mav=new ModelAndView("servicios");
        List<servicios> servicios= ServicioRepository.findAll();
        mav.addObject("servicios",servicios);
        return mav;
    }


}
