package com.medicavrai.webapp.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.medicavrai.webapp.CustomProperties;
import com.medicavrai.webapp.model.Utilisateur;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Log4j2
@Component
public class UtilisateurProxy {
	
	@Autowired
	private CustomProperties props;

	private static final Logger logger = LogManager.getLogger(HomeopathieProxy.class);
	
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		String baseApiUrl = props.getApiUrl();
		String getHomeopathiesUrl = baseApiUrl + "/creer_utilisateur";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Utilisateur> request = new HttpEntity<Utilisateur>(utilisateur);
		ResponseEntity<Utilisateur> response = restTemplate.exchange(getHomeopathiesUrl, HttpMethod.POST, request,Utilisateur.class);
		return response.getBody();
	}
}
