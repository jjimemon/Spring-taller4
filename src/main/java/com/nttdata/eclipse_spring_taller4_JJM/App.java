package com.nttdata.eclipse_spring_taller4_JJM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.eclipse_spring_taller4_JJM.persistence.NttdataClient;
import com.nttdata.eclipse_spring_taller4_JJM.services.NttdataClientManagementServiceI;

/**
 * Proyecto Spring taller 1.
 *
 * Clase Main de la app.
 * 
 * @author Javier Jiménez Montesinos.
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {
	/*
	 * Servicio de gestion de personas
	 */
	@Autowired
	NttdataClientManagementServiceI serviceClient;

	/**
	 * Método main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creacion de objetos
		NttdataClient client1 = new NttdataClient();
		client1.setDNI("20061899B");
		client1.setFechaNacimiento("15/09/2002");
		client1.setName("Manolito");
		client1.setLastName("Guzman");

		NttdataClient client2 = new NttdataClient();
		client2.setDNI("20023232C");
		client2.setFechaNacimiento("15/09/2002");
		client2.setName("Manolito");
		client2.setLastName("Benitez");

		// Llamada a los servicios
		serviceClient.insertNewClient(client1);
		serviceClient.insertNewClient(client2);
		System.out.println(serviceClient.findByNameAndLastName("Manolito", "Guzman"));
		System.out.println(serviceClient.findByName("Manolito"));

	}
}
