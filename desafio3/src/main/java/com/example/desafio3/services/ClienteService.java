package com.example.desafio3.services;

import com.example.desafio3.entities.Cliente;
import java.util.List;

public interface ClienteService {

    Cliente findClienteByNombreANDApellidos(String nombre, String apellidos);

    Cliente save(Cliente c);

    void deleteCliente(Cliente c);

    List<Cliente> getClientes();

    void deleteCliente(Long id);

    List<Cliente> findClienteByNombre(String nombre);

    List<Cliente> findAllByNombre(String nombre);
}
