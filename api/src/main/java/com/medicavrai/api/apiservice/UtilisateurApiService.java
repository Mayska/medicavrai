package com.medicavrai.api.apiservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
		Optional<Utilisateur> ofNullable = Optional.ofNullable(utilisateur);
		if(ofNullable.get() == null) {
			String msg = "[Erreur] l'utilisateur ne peut être vide.";
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, msg);
		}
		if(ofNullable.get().getMailUtilisateur().isEmpty()) {
			String msg = "[Erreur] le mail utilisateur ne peut être vide.";
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, msg);
		}
	}
	
	
}
