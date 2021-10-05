package com.medicavrai.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medicavrai.api.apiservice.HomeopathieApiService;
import com.medicavrai.api.model.Homeopathie;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Log4j2
@RestController
public class HomepathieController {

	@Autowired
	private HomeopathieApiService homeopatieApiService;
	
	private static final Logger logger = LogManager.getLogger(HomepathieController.class);

	@GetMapping("/homeopathies")
	public Iterable<Homeopathie> getHomeopathies() {
		logger.info("Test logger INFO");
		return homeopatieApiService.getHomeopathies();
	}

	@GetMapping("/homeopathie/{id}")
	public Homeopathie getHomeopathie(@PathVariable("id") final Long id) {
		return homeopatieApiService.getHomeopathieById(id);
	}
}
