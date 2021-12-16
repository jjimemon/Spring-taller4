package com.nttdata.eclipse_spring_taller4_JJM.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.eclipse_spring_taller4_JJM.persistence.NttdataClient;
import com.nttdata.eclipse_spring_taller4_JJM.services.NttdataClientManagementServiceI;

/**
 * Proyecto Dual Gestion.
 * 
 * Controlador de la ruta /home/welcome.
 * 
 * @author Javier Jiménez Montesino.
 * 
 */

@Controller
@RequestMapping("/home/welcome")
public class ControlerButtons {

	/*
	 * Instancia del servicio client
	 */
	@Autowired
	NttdataClientManagementServiceI serviceClient;

	/**
	 * respuesta hacia la vista searchClient.
	 * 
	 * Capta cualquier solicitud a /home/welcome/searchClient
	 * 
	 * @return String
	 */
	@GetMapping("/searchClient")
	public String searchClientView() {
		// Respuesta.
		final String responseBody = "clientSearch";

		System.out.println(responseBody);

		return responseBody;
	}

	/*
	 * Respuesta hacia la vista studentFound
	 * 
	 * @return String
	 */
	@PostMapping("/clientFound")
	public String clientFound(String name, Model model) {
		// Respuesta

		List<NttdataClient> clientsFound = serviceClient.findByName(name);

		model.addAttribute("client", clientsFound);

		return "/showClient";
	}

	/**
	 * respuesta hacia la vista addClient.
	 * 
	 * Capta cualquier solicitud a /home/welcome/addClient
	 * 
	 * @return String
	 */
	@GetMapping("/addClient")
	public String addClientView() {
		// Respuesta.
		final String responseBody = "addClient";

		System.out.println(responseBody);

		return responseBody;
	}

	/*
	 * Respuesta hacia la vista ClientADD
	 * 
	 * @return String
	 */
	@PostMapping("/ClientADD")
	public String clientAdd(String name, String lastName, String DNI, String fechaNacimiento) {

		// Creacion del objeto cliente a añadir

		NttdataClient clientADD = new NttdataClient();
		clientADD.setName(name);
		clientADD.setLastName(lastName);
		clientADD.setDNI(DNI);
		clientADD.setFechaNacimiento(fechaNacimiento);

		// Respuesta
		serviceClient.insertNewClient(clientADD);

		return "/index";
	}

	/**
	 * respuesta hacia la vista showAllClient.
	 * 
	 * Capta cualquier solicitud a /home/welcome/showAllClient
	 * 
	 * @return String
	 */
	@GetMapping("/showAllClient")
	public String addAllClientView(Model model) {

		// Respuesta.
		List<NttdataClient> listClient = serviceClient.findAll();

		model.addAttribute("client", listClient);

		return "showAllClient";
	}

	/*
	 * Respuesta hacia la vista ClientADD
	 * 
	 * @return String
	 */
	@PostMapping("/ClientDelete")
	public String clientDelete(Integer idClient) {

		// Creacion del objeto cliente a añadir

		Optional<NttdataClient> clientDelete = serviceClient.findByIdClient(idClient);

		NttdataClient client = clientDelete.get();

		// Respuesta

		serviceClient.deleteClient(client);

		return "/index";
	}

}
