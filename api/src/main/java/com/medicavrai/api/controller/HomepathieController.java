package com.medicavrai.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medicavrai.api.apiservice.HomeopathieApiService;
import com.medicavrai.api.model.Homeopathie;

@RestController
public class HomepathieController {

	@Autowired
	private HomeopathieApiService homeopatieApiService;

	@GetMapping("/homeopathies")
	public Iterable<Homeopathie> getHomeopathies() {
		return homeopatieApiService.getHomeopathies();
	}

	@GetMapping("/homeopathie/{id}")
	public Homeopathie getHomeopathie(@PathVariable("id") final Long id) {
		return homeopatieApiService.getHomeopathieById(id);
	}
}
