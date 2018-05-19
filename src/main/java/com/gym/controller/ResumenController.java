package com.gym.controller;

import com.gym.dao.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.gym.dao.ClienteRepository;
import com.gym.model.Cliente;
import java.math.BigDecimal;
import java.util.Calendar;
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

	@RequestMapping(value="/resumen/cargarGraficoResumenAnual/{anio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<Object []> cargarGraficoResumenAnual(@PathVariable Integer anio) {
		return pagoRepository.findGananciasByAnio(anio);
	}

	@RequestMapping(value="/resumen/cargarGraficoResumenMensual/{anio}/{mes}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<Object []> cargarGraficoResumenMensual(@PathVariable Integer anio, @PathVariable Integer mes) {
		List<Object []> gananciasMes = pagoRepository.findGananciasByAnioAndMes(anio, mes);
		Calendar calendar = Calendar.getInstance();
		calendar.set(anio, mes-1 ,1);
		int lastDayMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int day = 1; day  <= lastDayMonth; day++){
           boolean encontreDia = false;
			for(Object [] diaGanancia : gananciasMes){
				if((int)diaGanancia[0] == day){
					encontreDia = true;
					break;
				}
			}
			if(!encontreDia){
				Object [] newGananciaMes = {day, new BigDecimal(0)};
				gananciasMes.add(day - 1, newGananciaMes );
			}
		}
		return gananciasMes;
	}

}
