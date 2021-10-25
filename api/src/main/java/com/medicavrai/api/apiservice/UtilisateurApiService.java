package com.medicavrai.api.apiservice;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.medicavrai.api.model.Utilisateur;
import com.medicavrai.api.service.UtilisateurService;

@Service
public class UtilisateurApiService {
	
	@Autowired
	private UtilisateurService utilisateurService;

	public Iterable<Utilisateur> getUtilisateurs() {
		return utilisateurService.getUtilisateurs();
	}

	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		checkUtilisateur(utilisateur);
		return utilisateurService.saveUtilisateur(utilisateur);
	}

	private void checkUtilisateur(Utilisateur utilisateur) {
		Optional<String> ofNullable = Optional.ofNullable(utilisateur.getMailUtilisateur());
		if(!ofNullable.isPresent()) {
			String msg = "[Erreur] le mail utilisateur ne peut pas être vide.";
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, msg);
		}
	}
	
	
}
