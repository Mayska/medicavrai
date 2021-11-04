package com.medicavrai.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.medicavrai.webapp.CustomProperties;
import com.medicavrai.webapp.model.Homeopathie;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Log4j2
@Component
public class HomeopathieProxy {

	@Autowired
	private CustomProperties props;

	private static final Logger logger = LogManager.getLogger(HomeopathieProxy.class);
	
	public Iterable<Homeopathie> getHomeopathies() {
		String baseApiUrl = props.getApiUrl();
		String getHomeopathiesUrl = baseApiUrl + "/homeopathies";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Homeopathie>> response = restTemplate.exchange(getHomeopathiesUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<Iterable<Homeopathie>>() {
				});
		logger.info("Get Employees call " + response.getStatusCode().toString());
		return response.getBody();
	}

	public Homeopathie getHomeopathie(Long id) {
		String baseApiUrl = props.getApiUrl();
		String getHomeopathiesUrl = baseApiUrl + "/homeopathie/" + id;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Homeopathie> response = restTemplate.exchange(getHomeopathiesUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<Homeopathie>() {
				});
		return response.getBody();
	}

}
