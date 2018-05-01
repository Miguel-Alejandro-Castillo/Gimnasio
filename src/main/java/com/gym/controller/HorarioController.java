package com.gym.controller;

import com.gym.bean.HorarioBean;
import com.gym.dao.HorarioRepository;
import com.gym.model.Horario;
import com.gym.util.NumberUtils;
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
        mav.addObject("horarioBean", new HorarioBean());
        return mav;
    }

    @RequestMapping(value="/crearHorario", method = RequestMethod.POST)
    public  ModelAndView submitCreateHorario(@ModelAttribute("horarioBean") @Validated HorarioBean horarioBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("crear-horario");
        else{
        	Horario horario=new Horario(horarioBean.getId(),horarioBean.getHora_inicio(),horarioBean.getHora_fin());
            horarioRepository.save(horario);
            return new ModelAndView("redirect:/horarios");
        }

    }

    @RequestMapping(value="/{id_horario}/editar", method = RequestMethod.GET)
    public ModelAndView showEditarHorarioForm(@PathVariable(name = "id_horario") String id_horario){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_horario);
        Horario horario= horarioRepository.findOne(id);
        if(horario!=null) {
            HorarioBean horarioBean = new HorarioBean();
            horarioBean.load(horario);
            mav= new ModelAndView("editar-horario");
            mav.addObject("horarioBean", horario);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de horario en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_horario}/editar", method = RequestMethod.POST)
    public  ModelAndView submitEditHorario(@ModelAttribute("horarioBean") @Validated HorarioBean horarioBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("editar-horario");
        else{
        	Horario horario=new Horario(horarioBean.getId(),horarioBean.getHora_inicio(),horarioBean.getHora_fin());
            horarioRepository.save(horario);
            return new ModelAndView("redirect:/horarios");
        }

    };



}
