package com.medicavrai.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicavrai.api.model.SigneZodiaque;
import com.medicavrai.api.repository.SigneZodiaqueRepository;

import lombok.Data;

@Data
@Service
public class SigneZodiaqueService {

	@Autowired
	private SigneZodiaqueRepository signeZodiaqueRepository;

	public Iterable<SigneZodiaque> getSigneZodiaque() {
		Iterable<SigneZodiaque> findAll = signeZodiaqueRepository.findAll();
		return findAll;
	}
}
