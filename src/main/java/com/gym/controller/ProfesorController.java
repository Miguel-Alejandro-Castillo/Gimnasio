package com.gym.controller;

import com.gym.bean.ProfesorBean;
import com.gym.dao.ProfesorRepository;
import com.gym.model.Profesor;
import com.gym.util.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by negro
 */
@Controller
@RequestMapping(value="/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorRepository profesorRepository;

    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showProfesores(){
        ModelAndView mav=new ModelAndView("profesores");
        List<Profesor> profesores= profesorRepository.findAll();
        mav.addObject("profesores",profesores);
        return mav;
    }

    @RequestMapping(value="/crearProfesor", method = RequestMethod.GET)
    public ModelAndView showAltaProfesorForm(){
        ModelAndView mav=new ModelAndView("crear-profesor");
        mav.addObject("profesorBean", new ProfesorBean());
        return mav;
    }

    @RequestMapping(value="/crearProfesor", method = RequestMethod.POST)
    public  ModelAndView submitCreateProfesor(@ModelAttribute("profesorBean") @Validated ProfesorBean profesorBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("crear-profesor");
        else{
            Profesor profesor=new Profesor(profesorBean.getId(),profesorBean.getDni(),profesorBean.getNombre(),profesorBean.getApellido(),profesorBean.getFecha_de_nacimiento(),profesorBean.getTelefono(), profesorBean.getDireccion(),profesorBean.getEmail());
            profesorRepository.save(profesor);
            return new ModelAndView("redirect:/profesores");
        }

    }

    @RequestMapping(value="/{id_profesor}/editar", method = RequestMethod.GET)
    public ModelAndView showEditarProfesorForm(@PathVariable(name = "id_profesor") String id_profesor){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_profesor);
        Profesor profesor= profesorRepository.findOne(id);
        if(profesor!=null) {
            ProfesorBean profesorBean = new ProfesorBean();
            profesorBean.load(profesor);
            mav= new ModelAndView("editar-profesor");
            mav.addObject("profesorBean", profesor);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de profesor en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_profesor}/editar", method = RequestMethod.POST)
    public  ModelAndView submitEditProfesor(@ModelAttribute("profesorBean") @Validated ProfesorBean profesorBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("editar-profesor");
        else{
            Profesor profesor=new Profesor(profesorBean.getId(),profesorBean.getDni(),profesorBean.getNombre(),profesorBean.getApellido(),profesorBean.getFecha_de_nacimiento(),profesorBean.getTelefono(),profesorBean.getDireccion(),profesorBean.getEmail());
            profesorRepository.save(profesor);
            return new ModelAndView("redirect:/profesores");
        }

    }

}
