package com.gym.controller;

import com.gym.dao.ActividadRepository;
import com.gym.dao.PagoRepository;
import com.gym.model.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.gym.dao.ClienteRepository;
import com.gym.model.Cliente;
import com.gym.model.Pago;
import com.gym.util.NumberUtils;
import java.util.List;

@Controller
public class ResumenController{

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PagoRepository pagoRepository;

	@Autowired
	private ActividadRepository actividadRepository;
	
	@RequestMapping(value="/resumen", method = RequestMethod.GET)
	public ModelAndView showResumen() {
		ModelAndView mav = new ModelAndView("resumen");
		List<Cliente> clientes = clienteRepository.findAll();
		mav.addObject("clientes", clientes);
		List<Actividad> actividades = actividadRepository.findAll();
		mav.addObject("actividades", actividades);
		List<Integer> anios = this.pagoRepository.aniosConAlMenosUnPago();
		mav.addObject("anios", anios);
		return mav;
	}

	@RequestMapping( value = "/resumen/cargarGraficoResumen", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<Object[]> cargarGraficoResumen(@RequestParam(name = "mes", required = false) Integer mes, @RequestParam(name = "anio", required = false) Integer anio, @RequestParam(name = "idActividad", required = false) Long idActividad) {
		if(anio == null){
			return this.pagoRepository.gananciasAnuales(mes, idActividad);
		}
		else{
			if(mes == null){
				return this.pagoRepository.gananciasMensuales(anio, idActividad);
			}
			else{
				return this.pagoRepository.gananciasDiarias(anio, mes, idActividad);
			}
		}
	}


	@RequestMapping(value="/{id_pago}/detalle", method = RequestMethod.GET)
	public ModelAndView showPagoDetalle(@PathVariable(name = "id_pago") String id_pago){
		ModelAndView mav = null;
		Long id = NumberUtils.toLong(id_pago);
		Pago pago = pagoRepository.findOne(id);
		if(pago != null) {
			mav = new ModelAndView("pagoDetalle");
			mav.addObject("pago",pago);
		}
		return mav;
	}

}
