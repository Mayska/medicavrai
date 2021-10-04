package com.medicavrai.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicavrai.api.model.SigneZodiaque;
import com.medicavrai.api.service.SigneZodiaqueService;

@RestController
public class SigneZodiaqueController {

	@Autowired
	private SigneZodiaqueService signeZodiaqueService;

	@GetMapping("/signes")
	public Iterable<SigneZodiaque> getSigneZodiaque() {
		return signeZodiaqueService.getSigneZodiaque();
	}

}
