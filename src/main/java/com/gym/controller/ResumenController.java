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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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
		return mav;
	}

	@RequestMapping(value="/resumen/cargarGraficoResumenAnual{idActividad}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<Object []> cargarGraficoResumenAnual(
			@RequestParam(value = "anio", required = false) Integer anio,
			@RequestParam(value = "idActividad", required = false) Integer idActividad) {
		if(anio != null && idActividad != null){
			return pagoRepository.findGananciasByAnioAndIdActividad(anio, idActividad);
		}
		else{
			if( anio != null && idActividad == null){
				return pagoRepository.findGananciasByAnio(anio);
			}
			else{
				return new ArrayList<Object[]>();
			}
		}

	}

	@RequestMapping(value="/resumen/cargarGraficoResumenMensual", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<Object []> cargarGraficoResumenMensual(
			@RequestParam(value = "anio", required = false) Integer anio,
			@RequestParam(value = "mes", required = false) Integer mes,
			@RequestParam(value = "idActividad", required = false) Integer idActividad) {
		List<Object []> gananciasMes = new ArrayList<Object []>();
		if(anio != null && mes != null && idActividad != null){
			gananciasMes = pagoRepository.findGananciasByAnioAndMesAndIdActividad(anio, mes, idActividad);

			Calendar calendar = Calendar.getInstance();
			calendar.set(anio, mes - 1, 1);
			int lastDayMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			for (int day = 1; day <= lastDayMonth; day++) {
				boolean encontreDia = false;
				for (Object[] diaGanancia : gananciasMes) {
					if ((int) diaGanancia[0] == day) {
						encontreDia = true;
						break;
					}
				}
				if (!encontreDia) {
					Object[] newGananciaMes = {day, new BigDecimal(0)};
					gananciasMes.add(day - 1, newGananciaMes);
				}
			}

		}
		else {
			if(anio != null && mes != null && idActividad == null) {
				gananciasMes = pagoRepository.findGananciasByAnioAndMes(anio, mes);

				Calendar calendar = Calendar.getInstance();
				calendar.set(anio, mes - 1, 1);
				int lastDayMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				for (int day = 1; day <= lastDayMonth; day++) {
					boolean encontreDia = false;
					for (Object[] diaGanancia : gananciasMes) {
						if ((int) diaGanancia[0] == day) {
							encontreDia = true;
							break;
						}
					}
					if (!encontreDia) {
						Object[] newGananciaMes = {day, new BigDecimal(0)};
						gananciasMes.add(day - 1, newGananciaMes);
					}
				}
			}
			else{
				//
			}
		}

		return gananciasMes;
	}

	@RequestMapping(value="/resumen/cargarGraficoResumenMesualAnualActividad/{anio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<Object []> cargarGraficoResumen(@PathVariable Integer anio) {
		return pagoRepository.findGananciasByAnio(anio);
	}

}
