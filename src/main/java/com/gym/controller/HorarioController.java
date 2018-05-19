package com.gym.controller;

import com.gym.dao.HorarioRepository;
import com.gym.model.Horario;
import com.gym.util.NumberUtils;
import com.gym.validator.HorarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping(value="/horarios")
public class HorarioController {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private HorarioValidator horarioValidator;


    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showHorarios(){
        ModelAndView mav=new ModelAndView("horarios");
        List<Horario> horarios= horarioRepository.findAll();
        mav.addObject("horarios",horarios);
        return mav;
    }

    @RequestMapping(value="/crearHorario", method = RequestMethod.GET)
    public ModelAndView showAltaHorarioForm(){
        ModelAndView mav=new ModelAndView("crear-horario");
        mav.addObject("horario", new Horario());
        return mav;
    }

    @RequestMapping(value="/crearHorario", method = RequestMethod.POST)
    public  ModelAndView submitCreateHorario(@ModelAttribute("horario") @Validated Horario horario, BindingResult result){
        ModelAndView mav;
        if(result.hasErrors()) {
             mav = new ModelAndView("crear-horario");
        }
        else{
            horarioRepository.save(horario);
            mav = new ModelAndView("redirect:/horarios");
        }
        return mav;

    }


    @RequestMapping(value="/{id_horario}/editar", method = RequestMethod.GET)
    public ModelAndView showEditarHorarioForm(@PathVariable(name = "id_horario") String id_horario){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_horario);
        Horario horario= horarioRepository.findOne(id);
        if(horario!=null) {
            mav= new ModelAndView("editar-horario");
            mav.addObject("horario", horario);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de horario en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_horario}/editar", method = RequestMethod.POST)
    public  ModelAndView submitEditHorario(@ModelAttribute("horario") @Validated Horario horario, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("editar-horario");
        else{
            horarioRepository.save(horario);
            return new ModelAndView("redirect:/horarios");
        }

    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(horarioValidator);
    }


}
