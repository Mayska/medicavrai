package com.medicavrai.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.medicavrai.webapp.CustomProperties;
import com.medicavrai.webapp.model.SigneZodiaque;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SigneZodiaquePoxy {

	@Autowired
	private CustomProperties props;

	/**
	 * Get all employees
	 * 
	 * @return An iterable of all employees
	 */
	public Iterable<SigneZodiaque> getSigneZodiaque() {

		String baseApiUrl = props.getApiUrl();
		String getSigneZodiaqueUrl = baseApiUrl + "/signes";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<SigneZodiaque>> response = restTemplate.exchange(getSigneZodiaqueUrl, HttpMethod.GET,
				null, new ParameterizedTypeReference<Iterable<SigneZodiaque>>() {
				});

//		log.debug("Get SigneZodiaque call " + response.getStatusCode().toString());

		return response.getBody();
	}
}
