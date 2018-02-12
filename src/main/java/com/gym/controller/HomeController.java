package com.gym.controller;

import com.gym.bean.LoginBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alejandro on 12/2/2018.
 */
@Controller
public class HomeController {


    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String showHome(){
        return "home";
    }
}
