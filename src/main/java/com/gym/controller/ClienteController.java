package com.gym.controller;

import com.gym.bean.ClienteBean;
import com.gym.bean.LoginBean;
import com.gym.dao.ClienteRepository;
import com.gym.model.Administrador;
import com.gym.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * Created by Alejandro on 12/2/2018.
 */
@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value="/alta-cliente", method = RequestMethod.GET)
    public ModelAndView showAltaClienteForm(){
        ModelAndView mav=new ModelAndView("cliente");
        mav.addObject("clienteBean", new ClienteBean());
        return mav;
    }

    @RequestMapping(value={"/alta-cliente"}, method = RequestMethod.POST)
    public  ModelAndView submitClienteForm(@ModelAttribute("clienteBean") @Validated ClienteBean clienteBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("cliente");
        else{
            Cliente cliente=new Cliente(clienteBean.getDni(),clienteBean.getNombre(),clienteBean.getApellido(),clienteBean.getEdad(),clienteBean.getTelefono());
            clienteRepository.save(cliente);
            return new ModelAndView("redirect:/clientes");
        }

    }

    @RequestMapping(value="/editar-cliente/{id_cliente}", method = RequestMethod.GET)
    public ModelAndView showEditarClienteForm(@PathVariable(name = "id_cliente") Long id_cliente){
        ModelAndView mav=new ModelAndView("cliente");
        mav.addObject("clienteBean", new ClienteBean());
        return mav;
    }

    @RequestMapping(value="/clientes", method = RequestMethod.GET)
    public ModelAndView showClientes(){
        ModelAndView mav=new ModelAndView("clientes");
        Iterable<Cliente> clientes=clienteRepository.findAll();
        mav.addObject("clientes", clientes);
        return mav;
    }

}
