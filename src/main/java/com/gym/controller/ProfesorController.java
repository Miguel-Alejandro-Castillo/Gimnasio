package com.gym.controller;

import com.gym.dao.CobroRepository;
import com.gym.dao.ProfesorRepository;
import com.gym.model.Cobro;
import com.gym.model.Profesor;
import com.gym.util.NumberUtils;
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
 * Created by negro
 */
@Controller
@RequestMapping(value="/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private CobroRepository cobroRepository;

    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showProfesores(){
        ModelAndView mav = new ModelAndView("profesores");
        mav.addObject("profesores", this.profesorRepository.findByBorrado(false));
        return mav;
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Profesor> getProfesores(){
        return this.profesorRepository.findAll();
    }

    @RequestMapping(value="/crearProfesor", method = RequestMethod.GET)
    public ModelAndView showAltaProfesorForm(){
        ModelAndView mav=new ModelAndView("crear-profesor");
        mav.addObject("profesor", new Profesor());
        return mav;
    }

    @RequestMapping(value="/{id_profesor}/profesorDetalle", method = RequestMethod.GET)
    public ModelAndView showDetalleProfesor(@PathVariable(name = "id_profesor") String id_profesor){
    	ModelAndView mav = null;
    	Long id = NumberUtils.toLong(id_profesor);
    	Profesor profesor = profesorRepository.findOne(id);
        List<Cobro> cobrosProfesor;
    	if(profesor != null) {
    		mav = new ModelAndView("detalle-profesor");
    		cobrosProfesor = this.cobroRepository.findByProfesorId(profesor.getId());
            mav.addObject("profesor", profesor);
    		mav.addObject("cobros", cobrosProfesor);
    	}
        else{
            //renderizar una vista que informe que el profesor con id igual id_profesor no existe
        }
    	return mav;
    }
    
    @RequestMapping(value="/crearProfesor", method = RequestMethod.POST)
    public  ModelAndView submitCreateProfesor(@ModelAttribute("profesor") @Validated Profesor profesor, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("crear-profesor");
        else{
            profesorRepository.save(profesor);
            return new ModelAndView("redirect:/profesores");
        }
    }

    @RequestMapping(value="/{id_profesor}/editar", method = RequestMethod.GET)
    public ModelAndView showEditarProfesorForm(@PathVariable(name = "id_profesor") String id_profesor){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_profesor);
        Profesor profesor= profesorRepository.findOne(id);
        if(profesor!=null) {
            mav= new ModelAndView("editar-profesor");
            mav.addObject("profesor", profesor);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de profesor en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_profesor}/editar", method = RequestMethod.POST)
    public  ModelAndView submitEditProfesor(@ModelAttribute("profesor") @Validated Profesor profesor, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("editar-profesor");
        else{
            profesorRepository.save(profesor);
            return new ModelAndView("redirect:/profesores");
        }
    }

    @RequestMapping(value="/{idProfesor}/delete", method = RequestMethod.DELETE, produces="application/json; charset=UTF-8")
    public  @ResponseBody Boolean delete(@PathVariable(name = "idProfesor") Long idProfesor){
        Profesor profesor = this.profesorRepository.findOne(idProfesor);
        if(profesor != null){
            profesor.setBorrado(true);
            this.profesorRepository.save(profesor);
            return true;
        }
        else
            return false;
    }
}
