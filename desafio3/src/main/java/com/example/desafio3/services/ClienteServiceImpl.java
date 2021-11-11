package com.example.desafio3.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio3.dao.ClienteRepository;
import com.example.desafio3.entities.Cliente;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteRepository clienteDao;
	
	
	@Override
	@Transactional
	public Cliente findClienteByNombreANDApellidos(String nombre, String apellidos) {
		// TODO Auto-generated method stub
		return clienteDao.findClienteByNombreAndApellidos(nombre, apellidos);
	}


	@Override
	@Transactional
	public Cliente save(Cliente c) {
		// TODO Auto-generated method stub
		return clienteDao.save(c);
	}


	@Override
	public void deleteClient(Cliente c) {
		// TODO Auto-generated method stub
		clienteDao.delete(c);
	}

    @Override
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

}
