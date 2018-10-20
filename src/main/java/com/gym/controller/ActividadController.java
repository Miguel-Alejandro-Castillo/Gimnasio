package com.gym.controller;

import com.gym.dao.ActividadRepository;
import com.gym.dao.LeccionRepository;
import com.gym.dao.ProfesorRepository;
import com.gym.formatter.ProfesorEditor;
import com.gym.model.*;
import com.gym.util.NumberUtils;
import com.gym.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/actividades")
public class ActividadController {

    @Autowired
    private ProfesorEditor profesorEditor;

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private LeccionRepository leccionRepository;

    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showActividades(){
        ModelAndView mav = new ModelAndView("actividades");
        mav.addObject("actividades", this.actividadRepository.findByBorrado(false));
        return mav;
    }
    
    @RequestMapping(value="/crearActividad", method = RequestMethod.GET)
    public ModelAndView showAltaActividadForm(){
        ModelAndView mav=new ModelAndView("crearActividad");
        mav.addObject("actividad", new Actividad());
        List<Profesor> profesores = profesorRepository.findAll();
        mav.addObject("profesores", profesores);
        return mav;
    }

    @RequestMapping(value="/{id_actividad}/detalle", method = RequestMethod.GET)
    public ModelAndView showActividadDetalle(@PathVariable(name = "id_actividad") String id_actividad){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_actividad);
        Actividad actividad = actividadRepository.findOne(id);
        if(actividad != null) {
            mav= new ModelAndView("detalle-actividad");
            mav.addObject("actividad", actividad);
            mav.addObject("dias", Dia.values());
        }
        else {
            // renderizar a una vista que informe que no se envio un id de actividad en el path
        }
        return mav;
    }

    @RequestMapping(value="/crearActividad", method = RequestMethod.POST)
    public  ModelAndView submitCreateActividad(@ModelAttribute("actividad") @Validated Actividad actividad, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()) {
            mav = new ModelAndView("crearActividad");
            List<Profesor> profesores = profesorRepository.findAll();
            mav.addObject("profesores", profesores);
            return mav;
        }
        else{
            actividadRepository.save(actividad);
            mav=new ModelAndView("redirect:/actividades");
        }
        return mav;

    }

    @RequestMapping(value="/{id_actividad}/editar", method = RequestMethod.GET)
    public ModelAndView showEditarActividadForm(@PathVariable(name = "id_actividad") String id_actividad){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_actividad);
        Actividad actividad = actividadRepository.findOne(id);
        if(actividad != null) {
            mav= new ModelAndView("editar-actividad");
            mav.addObject("actividad", actividad);
            List<Profesor> profesores = profesorRepository.findAll();
            mav.addObject("profesores", profesores);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de actividad en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_actividad}/editar", method = RequestMethod.POST)
    public  ModelAndView submitEditActividad(@ModelAttribute("actividad") @Validated Actividad actividad, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()) {
            mav= new ModelAndView("editar-actividad");
            List<Profesor> profesores = profesorRepository.findAll();
            mav.addObject("profesores", profesores);
        }
        else{
            Actividad actividadDB = this.actividadRepository.findOne(actividad.getId());
            actividad.setLecciones(actividadDB.getLecciones());
            this.actividadRepository.save(actividad);
            mav = new ModelAndView("redirect:/actividades");
        }
        return mav;
    }

    @RequestMapping(value="/{id_actividad}/editar/agregarLeccion", method = RequestMethod.GET)
     public ModelAndView showAgregarLeccionForm(@PathVariable(name = "id_actividad") String id_actividad){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_actividad);
        Actividad actividad= actividadRepository.findOne(id);
        if(actividad != null) {
            mav= new ModelAndView("editar-actividad-agregar-leccion");
            Leccion leccion = new Leccion();
            mav.addObject("leccion", leccion);
            mav.addObject("urlAction", "/actividades/" + id + "/editar/agregarLeccion");
        }
        else {
            // renderizar a una vista que informe que no se envio un id de actividad en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_actividad}/editar/agregarLeccionPopup", method = RequestMethod.GET)
    public ModelAndView showAgregarLeccionFormPopup(@PathVariable(name = "id_actividad") String id_actividad){
        ModelAndView mav = null;
        Long id = NumberUtils.toLong(id_actividad);
        Actividad actividad= actividadRepository.findOne(id);
        if(actividad != null) {
            mav= new ModelAndView("editar-actividad-agregar-leccion-popup");
            Leccion leccion = new Leccion();
            mav.addObject("leccion", leccion);
            mav.addObject("urlAction", "/actividades/" + id + "/editar/agregarLeccionPopup");
        }
        else {
            // renderizar a una vista que informe que no se envio un id de actividad en el path
        }
        return mav;
    }
    
    @RequestMapping(value="/{id_actividad}/editar/agregarLeccion", method = RequestMethod.POST)
    public  ModelAndView submitAgregarLeccion(@PathVariable(name = "id_actividad") String idActividad, @ModelAttribute("leccion") @Validated Leccion leccion, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()) {
        	mav = new ModelAndView("editar-actividad-agregar-leccion");
        }else{
            Long id = NumberUtils.toLong(idActividad);
            Actividad actividad= actividadRepository.findOne(id);
        	actividad.getLecciones().add(leccion);
            actividadRepository.save(actividad);
            mav = new ModelAndView("redirect:/actividades");
        }
        return mav;
    }

    @RequestMapping(value="/{id_actividad}/editar/agregarLeccionPopup", method = RequestMethod.POST)
    public  @ResponseBody
    Response submitAgregarLeccionPopup(@PathVariable(name = "id_actividad") String idActividad, @ModelAttribute("leccion") @Validated Leccion leccion, BindingResult result){
          Response response = new Response();
          if(result.hasErrors()){
              Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
              response.setErrores(errors);
          }
          else{
              Actividad actividad = this.actividadRepository.findOne(Long.valueOf(idActividad));
              actividad.getLecciones().add(leccion);
              actividad = this.actividadRepository.save(actividad);
              response.setData(actividad);
          }
          return response;
    }

    @RequestMapping(value="/{idActividad}/delete", method = RequestMethod.DELETE, produces="application/json; charset=UTF-8")
    public  @ResponseBody Boolean deleteActividad(@PathVariable(name = "idActividad") String idActividad){
        Actividad actividad = this.actividadRepository.findOne(Long.valueOf(idActividad));
        if(actividad != null){
            actividad.setBorrado(true);
            this.actividadRepository.save(actividad);
            return true;
        }
        else
            return false;
    }

    @RequestMapping(value="/{idActividad}/leccion/{idLeccion}/delete", method = RequestMethod.DELETE, produces="application/json; charset=UTF-8")
    public  @ResponseBody Boolean deleteLeccion(@PathVariable(name = "idActividad") Long idActividad, @PathVariable(name = "idLeccion") Long idLeccion){
        boolean elimino = false;
        Actividad actividad = this.actividadRepository.findOne(idActividad);
        Leccion leccion = this.leccionRepository.findOne(idLeccion);
        if(actividad != null && leccion != null && actividad.getLecciones().contains(leccion)){
            if(actividad.getLecciones().remove(leccion)){
                elimino = true;
                this.actividadRepository.save(actividad);
            }

        }
        return elimino;
    }

    @RequestMapping(value="/{idActividad}/monto", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody BigDecimal getMonto(@PathVariable(name = "idActividad") String idActividad){
        return actividadRepository.findOne(NumberUtils.toLong(idActividad)).getCosto();
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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Profesor.class, this.profesorEditor);
    }
   

}