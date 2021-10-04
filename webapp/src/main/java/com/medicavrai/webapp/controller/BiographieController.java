package com.medicavrai.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BiographieController {

	@GetMapping("/biographie")
	public String index(Model model) {
		model.addAttribute("biographie", "biographie");
		return "index";
	}
}
