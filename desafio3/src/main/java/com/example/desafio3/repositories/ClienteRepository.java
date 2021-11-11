package com.example.desafio3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafio3.entities.Cliente;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findClienteByNombreAndApellidos(String nombre, String apellidos);
	List<Cliente> findClienteByNombre(String nombre);
	List<Cliente> findAllByNombre(String nombre);
}
