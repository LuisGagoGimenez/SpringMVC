package com.example.desafio3.services;

import com.example.desafio3.entities.Cliente;
import java.util.List;

public interface ClienteService {
	Cliente findClienteByNombreANDApellidos(String nombre, String apellidos);
	Cliente save(Cliente c);
	void deleteClient(Cliente c);

    public List<Cliente> getClientes();
}
