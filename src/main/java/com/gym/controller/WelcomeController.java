package com.gym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alejandro on 6/1/2018.
 */
@Controller
public class WelcomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mav=new ModelAndView("welcome");
        mav.addObject("message","Hola mundo");
        return   mav;
    }
}
