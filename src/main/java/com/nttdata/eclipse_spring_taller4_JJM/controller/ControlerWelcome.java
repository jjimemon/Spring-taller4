package com.nttdata.eclipse_spring_taller4_JJM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Proyecto Dual Gestion.
 * 
 * Controlador de la ruta /home/.
 * 
 * @author Javier Jiménez Montesino.
 * 
 */

@Controller
@RequestMapping("/home/")
public class ControlerWelcome {

	/**
	 * respuesta hacia vista la vista index.
	 * 
	 * Capta cualquier solicitud a /home/welcome
	 * 
	 * @return String
	 */
	@GetMapping("/welcome/")
	public String oneIndexView() {
		// Respuesta.
		final String responseBody = "index";
		System.out.println(responseBody);
		return responseBody;
	}
}
