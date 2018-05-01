package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gym.dao.ClienteRepository;
import com.gym.model.Cliente;

import java.util.List;

@Controller
public class ResumenController{

	@Autowired
	private ClienteRepository clienteRepository;

	@RequestMapping(value="/resumen", method = RequestMethod.GET)
	public ModelAndView showResumen() {
		ModelAndView mav = new ModelAndView("resumen");
		List<Cliente> clientes = clienteRepository.findAll();
		mav.addObject("clientes", clientes);
		return mav;
	}
}
