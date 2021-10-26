package com.medicavrai.api.apiservice;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.medicavrai.api.model.Utilisateur;
import com.medicavrai.api.repository.UtilisateurRepository;
import com.medicavrai.api.service.UtilisateurService;

@Service
public class UtilisateurApiService {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	/**
	 * Récupération de la liste des utilisateurs.
	 * @return
	 */
	public Iterable<Utilisateur> getUtilisateurs() {
		return utilisateurService.getUtilisateurs();
	}

	/**
	 * Vérification du contenu de utilisateur qui vient du front.
	 * @param utilisateur
	 * @return
	 */
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		checkUtilisateur(utilisateur);
		return utilisateurService.saveUtilisateur(utilisateur);
	}
	
	/**
	 * Vérification du contenu des données.
	 * Mail non vide
	 * @param utilisateur
	 */
	private void checkUtilisateur(Utilisateur utilisateur) {
		Optional<Utilisateur> utilisateurOptional = Optional.ofNullable(utilisateur);
		if(Objects.isNull(utilisateurOptional.get().getMailUtilisateur())) {
			String msg = "[Erreur] le mail utilisateur ne peut pas être vide.";
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
		}
	}

	/**
	 * Vérification de l'existance de l'objet suivant l'id technique.
	 * @param id
	 * @return
	 */
	public Utilisateur getUtilisateur(Long id) {
		if(!utilisateurRepository.existsById(id)) {
			String msg = "[Erreur] l'utilisateur demandé n'exsite pas avec l'id " + id;
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msg);
		}
		return utilisateurService.getUtilisateur(id);
	}
	
	
}
