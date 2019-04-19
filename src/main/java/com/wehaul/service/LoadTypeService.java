package com.wehaul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wehaul.model.LoadType;

@Service
public class LoadTypeService {

	@Value("${webservicebaseurl}")
	private String WS_BASE_URL = null;
	
	@Autowired
	private RestTemplate restTemplate;

	public List<LoadType> getAllActiveLoadType() {

		ResponseEntity<List<LoadType>> clientResponse = restTemplate.exchange(
				WS_BASE_URL+"/wehaul/loadtype/all-active", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<LoadType>>() {
				});

		return clientResponse.getBody();
	}

}