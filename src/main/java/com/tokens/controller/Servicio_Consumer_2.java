package com.tokens.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Servicio_Consumer_2 {

	@RequestMapping({"/test2"})
	public String Servicio_2() {
		return "Despliegue de nuevo servicio";
	}
}
