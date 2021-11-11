package com.example.desafio3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio3.entities.Cliente;
import com.example.desafio3.services.ClienteService;

@SpringBootApplication
public class Desafio3Application implements CommandLineRunner{

	//@Qualifier("Cliente_Servicio")
	
	
	@Autowired
	private ClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Desafio3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String entrada1 = "1999-12-29"; 
		DateFormat format = new SimpleDateFormat("YYYY-MM-DD"); 
		Date fecha = format.parse(entrada1);
		
		Cliente c = new Cliente();
		
		c.setNombre("Pepe");
		c.setApellidos("Gago Giménez");
		c.setFechaNacimiento(fecha);
		c.setDni("00011199J");
		
		clienteService.save(c);
		
		
		//clienteService.deleteClient(c);
		
	}

}
