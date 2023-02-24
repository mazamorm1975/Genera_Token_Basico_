package com.tokens.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Servicio_Consumer_3 {

	@RequestMapping({"/test_3"})
	public String Servicio_3() {
		return "Se despliega servicio_consumidor_3";
	}
	
}
