package com.example.desafio3.controllers;

import com.example.desafio3.entities.Cliente;
import com.example.desafio3.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/*")
public class HomeController {
    
    final String ADD = "anyadircliente";
    final String SHOW = "mostrarclientes";
    final String INDEX = "index";
    final String SEARCH = "buscarcliente";
    
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
    
    @PostMapping("/mostrarclientes")
    public String mostrarCliente(Model m) {
        List<Cliente> listaClientes = clienteService.getClientes();
        m.addAttribute("clientes", listaClientes);
        
        return SHOW;
    }
    
    
    @GetMapping("/borrarcliente/{id}") 
    public String borrarCliente(@PathVariable("id") Long id) {
        clienteService.deleteCliente(id);
        
        return "redirect:/mostrarclientes";
    }
    
    @GetMapping("/buscarcliente") 
    public String buscarCliente() {
        
        return SEARCH;
    }
    
    @PostMapping(path="/buscarclienteByName") 
    public String buscarCliente(@RequestParam("nombre") String nombre, Model m) {
        m.addAttribute("clientes", clienteService.findAllByNombre(nombre));
        return "buscarcliente";
    }
    
     @GetMapping("/")
    public String index() {
        return INDEX;
    }
}
