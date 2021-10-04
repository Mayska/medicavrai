package com.medicavrai.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.medicavrai.webapp.model.SigneZodiaque;
import com.medicavrai.webapp.service.SigneZodiaqueService;

import lombok.Data;

@Data
@Controller
public class SigneZodiaqueController {

	@Autowired
	private SigneZodiaqueService signeZodiService;

	@GetMapping("/signeszodiaque")
	public String home(Model model) {
		Iterable<SigneZodiaque> listSigneZodiaque = signeZodiService.getSigneZodiaque();
		model.addAttribute("signesZodiaque", listSigneZodiaque);
		return "home";
	}

}
