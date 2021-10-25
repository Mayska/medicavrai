package com.medicavrai.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicavrai.api.apiservice.UtilisateurApiService;
import com.medicavrai.api.model.Utilisateur;

@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurApiService utilisateurApiService;

	/**
	 * Affiche tous les utilisateurs
	 * @return
	 */
	@GetMapping("/utilisateurs")
	public Iterable<Utilisateur> getUtilisateurs() {
		return utilisateurApiService.getUtilisateurs();
	}
	
	/**
	 * Création d'un utilisateur.
	 * @param utilisateur
	 * @return
	 */
	@PostMapping("/creer_utilisateur")
	public Utilisateur creerUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurApiService.creerUtilisateur(utilisateur);
	}

}
