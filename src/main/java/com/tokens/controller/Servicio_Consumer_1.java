package com.tokens.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Servicio_Consumer_1 {

	@RequestMapping({"/test"})
	public String Saludo() {
		return "Despliegue de servicio Exitoso";
	}
}
