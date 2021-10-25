package com.medicavrai.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicavrai.api.model.Utilisateur;
import com.medicavrai.api.service.UtilisateurService;

@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("/utilisateurs")
	public Iterable<Utilisateur> getUtilisateur() {
		return utilisateurService.getUtilisateurs();
	}

}
