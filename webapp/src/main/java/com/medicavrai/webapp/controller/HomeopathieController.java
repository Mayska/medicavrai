package com.medicavrai.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medicavrai.webapp.model.Homeopathie;
import com.medicavrai.webapp.service.FrequenceQuantiqueService;
import com.medicavrai.webapp.service.HomeopathieService;

@Controller
public class HomeopathieController {

	@Autowired
	private HomeopathieService homeopathieService;

	@Autowired
	private FrequenceQuantiqueService frequenceQuantiqueService;

	@GetMapping("/homeopathies")
	public String getHomeopathies(Model model) {
		Iterable<Homeopathie> allHomeopathie = homeopathieService.getHomeopathies();
		model.addAttribute("homeopathies", allHomeopathie);
		return "index";

	}

	@GetMapping("/homeopathiefrequence/{id}")
	public String getHomeopathie(@PathVariable Long id, Model model) {
		model.addAttribute("homeopathies", homeopathieService.getHomeopathie(id));
		model.addAttribute("frequence", frequenceQuantiqueService.getFrequenceSonTellurique());
		return "index";
	}
}
