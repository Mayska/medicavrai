package com.medicavrai.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.medicavrai.webapp.CustomProperties;
import com.medicavrai.webapp.model.Homeopathie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HomeopathieProxy {

	@Autowired
	private CustomProperties props;

	public Iterable<Homeopathie> getHomeopathies() {
		String baseApiUrl = props.getApiUrl();
		String getHomeopathiesUrl = baseApiUrl + "/homeopathies";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Homeopathie>> response = restTemplate.exchange(getHomeopathiesUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<Iterable<Homeopathie>>() {
				});

//		log.debug("Get Employees call " + response.getStatusCode().toString());

		return response.getBody();
	}

	public Homeopathie getHomeopathie(Long id) {
		String baseApiUrl = props.getApiUrl();
		String getHomeopathiesUrl = baseApiUrl + "/homeopathie/" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Homeopathie> response = restTemplate.exchange(getHomeopathiesUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<Homeopathie>() {
				});

//		log.debug("Get Employees call " + response.getStatusCode().toString());

		return response.getBody();
	}

}
