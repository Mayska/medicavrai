package com.medicavrai.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * Recupère tous les utilisateurs
	 * @return
	 */
	@GetMapping("/utilisateurs")
	public ResponseEntity<Iterable<Utilisateur>> getUtilisateurs() {
		return ResponseEntity.ok(utilisateurApiService.getUtilisateurs());
	}
	
	/**
	 * Recupère un utilisateur
	 * @param id
	 * @return
	 */
	@GetMapping("/utilisateur/{id}")
	public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable("id") final Long id) {
		Utilisateur utilisateur = utilisateurApiService.getUtilisateur(id);
		return ResponseEntity.ok(utilisateur);
	}
	
	/**
	 * Création d'un utilisateur.
	 * @param utilisateur
	 * @return
	 */
	@PostMapping("/creer_utilisateur")
	public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur utilisateurSave = utilisateurApiService.creerUtilisateur(utilisateur);
		return ResponseEntity.ok(utilisateurSave);
	}

}
