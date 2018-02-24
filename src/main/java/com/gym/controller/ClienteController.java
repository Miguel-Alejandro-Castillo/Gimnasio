package com.gym.controller;

import com.gym.bean.ClienteBean;
import com.gym.dao.ClienteRepository;
import com.gym.model.Cliente;
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
 * Created by Alejandro on 12/2/2018.
 */
@Controller
@RequestMapping(value="/clientes")
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView showClientes(){
        ModelAndView mav=new ModelAndView("clientes");
        List<Cliente> clientes= clienteRepository.findAll();
        mav.addObject("clientes",clientes);
        return mav;
    }

    @RequestMapping(value="/crear", method = RequestMethod.GET)
    public ModelAndView showAltaClienteForm(){
        ModelAndView mav=new ModelAndView("crear-cliente");
        mav.addObject("clienteBean", new ClienteBean());
        return mav;
    }

    @RequestMapping(value="/crear", method = RequestMethod.POST)
    public  ModelAndView submitCreateCliente(@ModelAttribute("clienteBean") @Validated ClienteBean clienteBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("crear-cliente");
        else{
            Cliente cliente=new Cliente(clienteBean.getId(),clienteBean.getNombre(),clienteBean.getApellido(),clienteBean.getFecha_de_nacimiento(),clienteBean.getTelefono(), clienteBean.getDireccion(),clienteBean.getEmail(),clienteBean.getFacebook());
            clienteRepository.save(cliente);
            return new ModelAndView("redirect:/clientes");
        }

    }

    @RequestMapping(value="/{id_cliente}/editar", method = RequestMethod.GET)
    public ModelAndView showEditarClienteForm(@PathVariable(name = "id_cliente") String id_cliente){
        ModelAndView mav=null;
        Long id = NumberUtils.toLong(id_cliente);
        Cliente cliente= clienteRepository.findOne(id);
        if(cliente!=null) {
            ClienteBean clienteBean = new ClienteBean();
            clienteBean.load(cliente);
            mav= new ModelAndView("editar-cliente");
            mav.addObject("clienteBean", cliente);
        }
        else {
            // renderizar a una vista que informe que no se envio un id de cliente en el path
        }
        return mav;
    }

    @RequestMapping(value="/{id_cliente}/editar", method = RequestMethod.POST)
    public  ModelAndView submitEditCliente(@ModelAttribute("clienteBean") @Validated ClienteBean clienteBean, BindingResult result){
        if(result.hasErrors())
            return new ModelAndView("editar-cliente");
        else{
            Cliente cliente=new Cliente(clienteBean.getId(),clienteBean.getNombre(),clienteBean.getApellido(),clienteBean.getFecha_de_nacimiento(),clienteBean.getTelefono(),clienteBean.getDireccion(),clienteBean.getEmail(),clienteBean.getFacebook());
            clienteRepository.save(cliente);
            return new ModelAndView("redirect:/clientes");
        }

    }

}
