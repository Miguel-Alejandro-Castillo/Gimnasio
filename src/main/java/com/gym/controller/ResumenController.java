package com.gym.controller;

import com.gym.dao.PagoRepository;
import com.gym.util.MesGanancia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.gym.dao.ClienteRepository;
import com.gym.model.Cliente;
import java.util.List;

@Controller
public class ResumenController{

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PagoRepository pagoRepository;

	@RequestMapping(value="/resumen", method = RequestMethod.GET)
	public ModelAndView showResumen() {
		ModelAndView mav = new ModelAndView("resumen");
		List<Cliente> clientes = clienteRepository.findAll();
		mav.addObject("clientes", clientes);
		return mav;
	}

	@RequestMapping(value="/resumen/cargarGraficoResumenAnual", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<MesGanancia> cargarGraficoResumenAnual() {
		//Se debe obtener  el año actual de forma dinamica
		return pagoRepository.findGananciasByAnio(2018);
	}

}
