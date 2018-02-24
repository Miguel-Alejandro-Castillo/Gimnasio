package com.gym.controller;

import com.gym.dao.AdministradorRepository;
import com.gym.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alejandro on 6/1/2018.
 */
@Controller
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AdministradorRepository administradorRepository;


    private boolean isAunthenticated(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return !(auth instanceof AnonymousAuthenticationToken);
    }
    @RequestMapping(value={"/",""}, method = RequestMethod.GET)
    public String index(){
        if (isAunthenticated())
            return "redirect:/home";
        else
            return "redirect:/login";
    }


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm(@RequestParam( value="error", required = false, defaultValue = "false")
                                          boolean error){
        if(isAunthenticated()){
            return new ModelAndView("redirect:/home");
        }
        else {
            ModelAndView mav = new ModelAndView("login");
            if (error)
                mav.addObject("loginError", messageSource.getMessage("login.error", null, null));
            return mav;
        }
    }

    @RequestMapping(value="/init", method = RequestMethod.GET)
    public String init(){
        Administrador admin= new Administrador();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setNombre("pepe");
        admin.setApellido("metiche");
        administradorRepository.save(admin);
        return "redirect:/";
    }
}
