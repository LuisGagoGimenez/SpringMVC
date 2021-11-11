package com.example.desafio3.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio3.repositories.ClienteRepository;
import com.example.desafio3.entities.Cliente;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente findClienteByNombreANDApellidos(String nombre, String apellidos) {
        // TODO Auto-generated method stub
        return clienteRepository.findClienteByNombreAndApellidos(nombre, apellidos);
    }

    @Override
    @Transactional
    public Cliente save(Cliente c) {
        // TODO Auto-generated method stub
        return clienteRepository.save(c);
    }

    @Override
    public void deleteCliente(Cliente c) {
        // TODO Auto-generated method stub
        clienteRepository.delete(c);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> findClienteByNombre(String nombre) {
        
        return clienteRepository.findClienteByNombre(nombre);
    }
    @Override
    public List<Cliente> findAllByNombre(String nombre) {
        return clienteRepository.findAllByNombre(nombre);
    }
}
