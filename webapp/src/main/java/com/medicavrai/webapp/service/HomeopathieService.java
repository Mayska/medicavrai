package com.medicavrai.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicavrai.webapp.model.Homeopathie;
import com.medicavrai.webapp.repository.HomeopathieProxy;

import lombok.Data;

@Data
@Service
public class HomeopathieService {

	@Autowired
	private HomeopathieProxy homeopathieProxy;

	public Iterable<Homeopathie> getHomeopathies() {
		return homeopathieProxy.getHomeopathies();
	}

	public Homeopathie getHomeopathie(Long id) {
		return homeopathieProxy.getHomeopathie(id);
	}

}
