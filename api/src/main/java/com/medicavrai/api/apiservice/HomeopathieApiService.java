package com.medicavrai.api.apiservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import com.medicavrai.api.model.Homeopathie;
import com.medicavrai.api.service.HomeopathieService;

@Service
public class HomeopathieApiService {

	@Autowired
	private HomeopathieService homeopatieService;

	/**
	 * Recuperation de la liste homeopathie. 
	 * @return
	 */
	public Iterable<Homeopathie> getHomeopathies() {
		Optional<Iterable<Homeopathie>> optionalHomeopathies = Optional.ofNullable(homeopatieService.getHomeopathies());
		if (!optionalHomeopathies.isPresent()) {
			String msg = "[Erreur] lors de la récupération des données homéopaties.";
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
		}
		return optionalHomeopathies.get();
	}

	public Homeopathie getHomeopathieById(Long id) {
		Optional<Homeopathie> optionalHomeopathie = homeopatieService.getHomeopathie(id);
		if (!optionalHomeopathie.isPresent()) {
			String msg = "[Erreur] lors de la récupération de la donnée homéopatie pour l'di = " + id;
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
		}
		return optionalHomeopathie.get();

	}

}
