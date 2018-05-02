package com.gym.controller;

import com.gym.bean.ActividadBean;
import com.gym.dao.ActividadRepository;
import com.gym.dao.DiaHorarioProfesorRepository;
import com.gym.dao.HorarioRepository;
import com.gym.dao.ProfesorRepository;
import com.gym.model.*;
import com.gym.util.DiaHorarioProfesorDTO;
import com.gym.util.NumberUtils;
import com.gym.util.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuPaPá on 12/2/2018.
 */
@Controller
@RequestMapping(value="/actividades")
public class ActividadController {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private DiaHorarioProfesorRepository diaHorarioProfesorRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

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
        ModelAndView mav=new ModelAndView("crear-actividad");
        this.actividadBean= new ActividadBean();
        mav.addObject("actividadBean", this.actividadBean);
        String []dias={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
        mav.addObject("dias",dias);
        List<Horario> horarios= horarioRepository.findAll();
        mav.addObject("horarios",horarios);
        List<Profesor> profesores=profesorRepository.findAll();
        mav.addObject("profesores",profesores);
        return mav;
    }

    @RequestMapping(value="/addDiaHorarioProfesor", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody ObjectResponse submitAddDiaHorarioProfesor( @RequestBody DiaHorarioProfesorDTO diaHorarioProfesorDTO){
        Dia dia = diaHorarioProfesorDTO.getNewDia();
        Horario horario = horarioRepository.findOne(diaHorarioProfesorDTO.getNewHorario());
        Profesor profesor = profesorRepository.findOne(diaHorarioProfesorDTO.getNewProfesor());
        DiaHorarioProfesor diaHorarioProfesor = new DiaHorarioProfesor( dia , horario, profesor);
        if(!this.actividadBean.getDiasHorariosProfesores().contains(diaHorarioProfesor)) {
            this.actividadBean.getDiasHorariosProfesores().add(diaHorarioProfesor);
            return new ObjectResponse( diaHorarioProfesor, "success");
        }
        else
            return new ObjectResponse( null, "failure.diaHorarioProfesor.existente");
    }

    @RequestMapping(value="/crearActividad", method = RequestMethod.POST)
    public  ModelAndView submitCreateActividad(@ModelAttribute("actividadBean") @Validated ActividadBean actividadBean, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()) {
            mav = new ModelAndView("crear-actividad");
            String []dias={"Lunes", "Martes", "Miercoles","Jueves","Viernes","Sabado"};
            mav.addObject("dias",dias);
            List<Horario> horarios = horarioRepository.findAll();
            mav.addObject("horarios",horarios);
            List<Profesor> profesores=profesorRepository.findAll();
            mav.addObject("profesores",profesores);
            actividadBean.setDiasHorariosProfesores(this.actividadBean.getDiasHorariosProfesores());
            return mav;
        }
        else{
            Actividad actividad = new Actividad(actividadBean.getId(), actividadBean.getNombre(), actividadBean.getCosto(), this.actividadBean.getDiasHorariosProfesores());
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
            String []dias={"Lunes", "Martes", "Miercoles","Jueves","Viernes","Sabado"};
            mav.addObject("dias",dias);
            List<Horario> horarios = horarioRepository.findAll();
            mav.addObject("horarios",horarios);
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
            String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
            mav.addObject("dias", dias);
            List<Horario> horarios = horarioRepository.findAll();
            mav.addObject("horarios", horarios);
            List<Profesor> profesores = profesorRepository.findAll();
            mav.addObject("profesores", profesores);
            actividadBean.setDiasHorariosProfesores(this.actividadBean.getDiasHorariosProfesores());
        }
        else{
        	Actividad actividad=new Actividad(actividadBean.getId(), actividadBean.getNombre(), actividadBean.getCosto(),this.actividadBean.getDiasHorariosProfesores());
            actividadRepository.save(actividad);
            mav = new ModelAndView("redirect:/actividades");
        }
        return mav;

    }




}
