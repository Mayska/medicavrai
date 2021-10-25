package com.medicavrai.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicavrai.api.model.Utilisateur;
import com.medicavrai.api.repository.UtilisateurRepository;

import lombok.Data;

@Data
@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	public Iterable<Utilisateur> getUtilisateurs() {
		Iterable<Utilisateur> findAll = utilisateurRepository.findAll();
		return findAll;
	}
	
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		Utilisateur utilisateurSave = utilisateurRepository.save(utilisateur);
		return utilisateurSave;
	}

}
