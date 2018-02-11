package com.gym.controller;


import com.gym.dao.AdministradorDAOImplHibernate;
import com.gym.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alejandro on 6/1/2018.
 */
@Controller
public class WelcomeController {
   @Autowired
   private AdministradorDAOImplHibernate administradorDAOImplHibernate;
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mav=new ModelAndView("welcome");
        mav.addObject("message","Hola mundo");
        return   mav;
    }
    @RequestMapping(value="/init", method = RequestMethod.GET)
    public ModelAndView init(){
        Administrador admin= new Administrador();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setNombre("pepe");
        admin.setApellido("metiche");
        administradorDAOImplHibernate.save(admin);
        ModelAndView mav=new ModelAndView("redirect:/");
        mav.addObject("message","Hola mundo");
        return   mav;
    }
}
