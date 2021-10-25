package com.medicavrai.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medicavrai.webapp.apiservice.UtilisateurApiServcie;
import com.medicavrai.webapp.model.Utilisateur;

@Controller
public class CompteUtilisateur {
	
	@Autowired
	private UtilisateurApiServcie utilisateurApiServcie;
	
	@GetMapping("/creer_compte_uilisateur")
	public String creerCompteUtilisateur(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("formulairecompte", "formulairecompte" );
		return "index";
	}
	
	@PostMapping("/sauvegarde_utilisateur")
    public String submit(@ModelAttribute Utilisateur utilisateur, Model model) {
		List<String> verificationFormulaireUtilisateur = utilisateurApiServcie.verificationFormulaireUtilisateur(utilisateur);
		model.addAttribute("erreurs", verificationFormulaireUtilisateur );
		model.addAttribute("formulairecompte", "formulairecompte" );
        return "index";
    }
	
}
