package com.medicavrai.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicavrai.webapp.model.Utilisateur;
import com.medicavrai.webapp.repository.UtilisateurProxy;

@Service
public class UtilisateurServcie {
	
	@Autowired
	private UtilisateurProxy utilisateurProxy;

	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		return utilisateurProxy.saveUtilisateur(utilisateur);
	}
	
	
	
	
}
