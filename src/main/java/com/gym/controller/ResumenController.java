package com.gym.controller;

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
import com.gym.model.Cliente;

@Controller
public class ResumenController{
	
	@RequestMapping(value="/resumen",method = RequestMethod.GET)
	public String showResumen() {
		return "resumen";
	}
}
