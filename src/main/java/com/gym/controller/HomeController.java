package com.gym.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gym.dao.ClienteRepository;
import com.gym.model.Actividad;
import com.gym.model.Cliente;
import com.gym.model.Pago;

/**
 * Created by Alejandro on 12/2/2018.
 */
@Controller
@RequestMapping(value="/home")
public class HomeController {
    
    @Autowired  
    private ClienteRepository clienteRepository;
  
    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showListaClientes(){
        ModelAndView mav = new ModelAndView("home");
        List<Cliente> clientes = clienteRepository.findAll();
        
        Map<Pago,Cliente> pagosAdeudados = new HashMap<Pago,Cliente>();

        for(int i = 1; i < clientes.size(); i++) {
            Cliente cli = clientes.get(i);
            if(!cli.getPagos().isEmpty()) {

                Set<Pago> pagos = cli.getPagos();
                Set<Actividad> act = new HashSet<Actividad>();

                //obtengo set de actividades del cliente
                for(Iterator<Pago> p = pagos.iterator(); p.hasNext();) { 
                    Pago pago = p.next();
                    if( !act.contains(pago.getActividad())){
                        act.add(pago.getActividad());
                    }
                }

                //obtengo lista de pagos por actividad
                for (Iterator<Actividad> a = act.iterator(); a.hasNext();) {

                    Actividad actAux = a.next();
                    List<Pago> lista = new ArrayList<Pago>();
                    for(Iterator<Pago> p = pagos.iterator(); p.hasNext();) { 
                        Pago pago = p.next();
                        if(pago.getActividad().getNombre().equals(actAux.getNombre())){
                            lista.add(pago);
                        }
                    }

                    //obtengo ultimo pago
                    Pago ultimoPago = null;
                    Date max = new Date(0); //epoch
                    for(Iterator<Pago> p = lista.iterator(); p.hasNext();) { 
                        Pago pago = p.next();
                        if (pago.getFechaHasta().after(max)){
                            max = pago.getFechaHasta();
                            ultimoPago = pago;
                        }
                    }

                    //si adeuda y no pasaron tres meses, se agrega en la lista de pagos adeudados
                    
                    Date date = new Date(); 
                    Date tresMeses = new DateTime(date).minusMonths(3).toDate();
                    
                    if(ultimoPago.getFechaHasta().before(new Date()) && 
                    	ultimoPago.getFechaHasta().after(tresMeses)){
                        pagosAdeudados.put(ultimoPago,cli);    
                    }           
                }
            }                
        }
        
        mav.addObject("tabla", pagosAdeudados);
        mav.addObject("clientes",clientes);
        return mav;
        
    }
}
   