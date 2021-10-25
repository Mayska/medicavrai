package com.medicavrai.webapp.apiservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.medicavrai.webapp.model.Utilisateur;

@Service
public class UtilisateurApiServcie {
	
	private String ERREUR_MAIL_VIDE = "L'adresse mail ne doit pas être vide.";
	private String ERREUR_MAIL_FORMAT = "Le format de l'adresse est incorrect.";
	
	
	public List<String> verificationFormulaireUtilisateur(Utilisateur utilisateur) {
		List<String> listErreur =new ArrayList<String>();
		
		if(utilisateur.getMailUtilisateur().isEmpty()) {
			listErreur.add(ERREUR_MAIL_VIDE);
		}
		if(!utilisateur.getMailUtilisateur().contains("@")) {
			listErreur.add(ERREUR_MAIL_FORMAT);
		}
		return listErreur;	
	}
	
}
