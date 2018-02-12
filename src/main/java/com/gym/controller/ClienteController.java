package com.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alejandro on 12/2/2018.
 */
@Controller
public class ClienteController {

    @RequestMapping(value="/alta-cliente", method = RequestMethod.GET)
    public String showClienteForm(){
        return "cliente";
    }
}
