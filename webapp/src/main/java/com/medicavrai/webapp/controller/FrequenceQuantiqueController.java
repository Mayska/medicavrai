package com.medicavrai.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.medicavrai.webapp.service.FrequenceQuantiqueService;

@Controller
public class FrequenceQuantiqueController {

	@Autowired
	private FrequenceQuantiqueService frequenceQuantiqueService;

	@GetMapping("/frequence")
	public String getFrequenceQuantique(Model model) {
		model.addAttribute("frequence", frequenceQuantiqueService.getFrequenceSonTellurique());
		return "index";

	}

}
