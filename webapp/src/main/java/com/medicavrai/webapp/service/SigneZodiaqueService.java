package com.medicavrai.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicavrai.webapp.model.SigneZodiaque;
import com.medicavrai.webapp.repository.SigneZodiaquePoxy;

@Service
public class SigneZodiaqueService {

	@Autowired
	private SigneZodiaquePoxy signeZodiaquePoxy;

	public Iterable<SigneZodiaque> getSigneZodiaque() {
		return signeZodiaquePoxy.getSigneZodiaque();
	}
}
