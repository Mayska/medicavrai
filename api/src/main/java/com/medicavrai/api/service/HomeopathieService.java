package com.medicavrai.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicavrai.api.model.Homeopathie;
import com.medicavrai.api.repository.HomeopathieRepository;

import lombok.Data;

@Data
@Service
public class HomeopathieService {

	@Autowired
	private HomeopathieRepository homeopatieRepository;

	/**
	 * Récupérer totalité de la table homeopatie
	 * 
	 * @param iterable
	 * 
	 * @return Iterable<Homeopathie>
	 */
	public Iterable<Homeopathie> getHomeopathies() {
		Iterable<Homeopathie> findAll = homeopatieRepository.findAll();
		return findAll;
	}

	public Optional<Homeopathie> getHomeopathie(Long id) {
		Optional<Homeopathie> findById = homeopatieRepository.findById(id);
		return findById;
	}
}
