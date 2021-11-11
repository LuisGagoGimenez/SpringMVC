package com.example.desafio3.controllers;

import com.example.desafio3.entities.Cliente;
import com.example.desafio3.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping("/*")
public class HomeController {
    
    final String ADD = "anyadircliente";
    final String SHOW = "mostrarclientes";
    final String INDEX = "index";
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/anyadircliente")
    public String añadirClientes() {
        return ADD;
    }
    
    @PostMapping("/anyadircliente")
    public String añadirCliente(@ModelAttribute("nuevoCliente") Cliente c) {
        clienteService.save(c);
        
        return "redirect:/mostrarclientes";
    }
    
    @GetMapping("/mostrarclientes")
    public String mostrarClientes(Model m) {
        List<Cliente> listaClientes = clienteService.getClientes();
        m.addAttribute("clientes", listaClientes);
        
        return SHOW;
    }
    
     @GetMapping("/")
    public String index() {
        return INDEX;
    }
}
