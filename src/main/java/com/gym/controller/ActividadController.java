package com.gym.controller;

import com.gym.bean.ActividadBean;
import com.gym.dao.ActividadRepository;
import com.gym.dao.CobroRepository;
import com.gym.dao.HorarioRepository;
import com.gym.dao.ProfesorRepository;
import com.gym.model.*;
import com.gym.util.LeccionDTO;
import com.gym.util.NumberUtils;
import com.gym.util.ObjectResponse;
import com.gym.validator.HorarioValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping(value="/actividades")
public class ActividadController {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private ProfesorRepository profesorRepository;
    
    @Autowired
	private CobroRepository cobroRepository;
    @Autowired
    private HorarioValidator horarioValidator;

        

    private ActividadBean actividadBean;
    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showActividades(){
        ModelAndView mav=new ModelAndView("actividades");
        List<Actividad> actividades= actividadRepository.findAll();
        mav.addObject("actividades",actividades);
        return mav;
    }
    
    @RequestMapping(value="/crearActividad", method = RequestMethod.GET)
    public ModelAndView showAltaActividadForm(){
        ModelAndView mav=new ModelAndView("crearActividad");
        this.actividadBean= new ActividadBean();
        mav.addObject("actividadBean", this.actividadBean);
        List<Profesor> profesores=profesorRepository.findAll();
        mav.addObject("profesores",profesores);
        
        return mav;
    }

    @RequestMapping(value="/crearActividad", method = RequestMethod.POST)
    public  ModelAndView submitCreateActividad(@ModelAttribute("actividadBean") @Validated ActividadBean actividadBean, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()) {
            mav = new ModelAndView("crearActividad");
            this.actividadBean= new ActividadBean();
            mav.addObject("actividadBean", this.actividadBean);
            List<Profesor> profesores=profesorRepository.findAll();
            mav.addObject("profesores",profesores);
            return mav;
        }
        else{
            Actividad actividad = new Actividad(actividadBean.getId(), actividadBean.getNombre(), actividadBean.getCosto(), actividadBean.getProfesor());
            actividadRepository.save(actividad);
            mav=new ModelAndView("redirect:/actividades");
        }
        return mav;

    }

    @RequestMapping(value="/{id_actividad}/editar", method = RequestMethod.GET)
    public ModelAndView showEditarActividadForm(@PathVariable(name = "id_actividad") String id_actividad){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_actividad);
        Actividad actividad= actividadRepository.findOne(id);
        if(actividad!=null) {
            this.actividadBean = new ActividadBean();
            this.actividadBean.load(actividad);
            mav= new ModelAndView("editar-actividad");
            mav.addObject("actividadBean", this.actividadBean);
            List<Profesor> profesores=profesorRepository.findAll();
            mav.addObject("profesores",profesores);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de actividad en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_actividad}/editar", method = RequestMethod.POST)
    public  ModelAndView submitEditActividad(@ModelAttribute("actividadBean") @Validated ActividadBean actividadBean, BindingResult result){
        ModelAndView mav=null;
        if(result.hasErrors()) {
            mav= new ModelAndView("editar-actividad");
            List<Profesor> profesores = profesorRepository.findAll();
            mav.addObject("profesores", profesores);
        }
        else{
        	Actividad actividad=new Actividad(actividadBean.getId(), actividadBean.getNombre(), actividadBean.getCosto(),actividadBean.getProfesor());
            actividadRepository.save(actividad);
            mav = new ModelAndView("redirect:/actividades");
        }
        return mav;
    }

    @RequestMapping(value="/{id_actividad}/editar/agregarLeccion", method = RequestMethod.GET)
    public ModelAndView showAgregarLeccionForm(@PathVariable(name = "id_actividad") String id_actividad){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_actividad);
        Actividad actividad= actividadRepository.findOne(id);
        if(actividad!=null) {
            this.actividadBean = new ActividadBean();
            this.actividadBean.load(actividad);
            
            mav= new ModelAndView("editar-actividad-agregar-leccion");
            Leccion leccion = new Leccion();
            leccion.setHorario(new Horario());
            mav.addObject("leccion", leccion);
            mav.addObject("actividadBean", this.actividadBean);   
        }
        else {
            // renderizar a una vista que informe que no se envio un id de actividad en el path
        }
        return mav;
    }
    
    @RequestMapping(value="/{id_actividad}/editar/agregarLeccion", method = RequestMethod.POST)
    public  ModelAndView submitAgregarLeccion(@ModelAttribute("leccion") Leccion leccion, BindingResult result, ActividadBean actividadBean){
        ModelAndView mav=null;
        if(result.hasErrors()) {
        	mav= new ModelAndView("editar-actividad-agregar-leccion");
        	leccion = new Leccion();
            leccion.setHorario(new Horario());
            mav.addObject("leccion", leccion);
            mav.addObject("actividadBean", this.actividadBean);
        }else{
        	Actividad actividad=new Actividad(actividadBean.getId(), actividadBean.getNombre(), actividadBean.getCosto(),actividadBean.getProfesor());
        	if(!actividad.getLecciones().contains(leccion)) {
        		actividad.getLecciones().add(leccion);
        	}
            actividadRepository.save(actividad);
            mav = new ModelAndView("redirect:/actividades");
        }
        return mav;
    }

    
    /*
    @RequestMapping(value="/addLeccion", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody ObjectResponse submitAddLeccion( @RequestBody Leccion leccion){
        Dia dia = leccionDTO.getNewDia();
        Horario horario = horarioRepository.findOne(leccionDTO.getNewHorario());
        Leccion leccion = new Leccion( dia , horario);
        if(!this.actividadBean.getLecciones().contains(leccion)) {//si ya existe el dhp en la lista 
            this.actividadBean.getLecciones().add(leccion);
            return new ObjectResponse( leccion, "success");
        }
        else
            return new ObjectResponse( null, "failure.diaHorarioProfesor.existente");
    }
    */
   

}