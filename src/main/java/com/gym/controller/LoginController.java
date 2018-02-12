package com.gym.controller;


import com.gym.bean.LoginBean;
import com.gym.dao.AdministradorIDao;
import com.gym.model.Administrador;
import com.gym.validator.ValidatorLoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Created by Alejandro on 6/1/2018.
 */
@Controller
public class LoginController {
     @Autowired
     private AdministradorIDao administradorIDao;

    @Autowired
    private ValidatorLoginBean validatorLoginBean;

    @Autowired
    private MessageSource messageSource;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validatorLoginBean);
    }

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView showLoginForm(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("loginBean", new LoginBean());
        return mav;
    }
    @RequestMapping(value={"/login"}, method = RequestMethod.POST)
    public  ModelAndView submitLoginForm(@ModelAttribute("loginBean") @Validated LoginBean loginBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("login");
        else{
              Administrador admin= administradorIDao.get(loginBean.getUsername(),loginBean.getPassword());
              if(admin == null)
                  return new ModelAndView("login").addObject("loginError",messageSource.getMessage("login.error",null,null));
              else
                  return new ModelAndView("redirect:/home");
        }

    }

    @RequestMapping(value="/init", method = RequestMethod.GET)
    public ModelAndView init(){
        Administrador admin= new Administrador();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setNombre("pepe");
        admin.setApellido("metiche");
        administradorIDao.save(admin);
        ModelAndView mav=new ModelAndView("redirect:/");
        mav.addObject("message","Hola mundo");
        return   mav;
    }
}
