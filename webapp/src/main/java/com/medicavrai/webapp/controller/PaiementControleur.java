package com.medicavrai.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.medicavrai.webapp.model.Homeopathie;

@Controller
public class PaiementControleur {
	@GetMapping("/paiementint")
	public String getPresentationCarte(Model model) {
		model.addAttribute("paiement", "paiement");
		return "index";
	}
}
