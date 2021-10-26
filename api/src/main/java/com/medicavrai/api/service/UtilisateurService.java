package com.medicavrai.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicavrai.api.model.Utilisateur;
import com.medicavrai.api.repository.UtilisateurRepository;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Log4j2
@Data
@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	private static final Logger logger = LogManager.getLogger(UtilisateurService.class);
	
	public Iterable<Utilisateur> getUtilisateurs() {
		Iterable<Utilisateur> findAll = utilisateurRepository.findAll();
		return findAll;
	}
	
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		Utilisateur utilisateurSave = utilisateurRepository.save(utilisateur);
		logger.info("Création de l'utilisateur d'id : {}.",utilisateurSave.getId() );
		return utilisateurSave;
	}

	public Utilisateur getUtilisateur(Long id) {
		return utilisateurRepository.findById(id).get();	
	}

}
