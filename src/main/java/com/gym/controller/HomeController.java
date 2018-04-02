package com.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gym.dao.ClienteRepository;
import com.gym.model.Cliente;;

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
