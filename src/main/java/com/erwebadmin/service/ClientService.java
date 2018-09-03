package com.erwebadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erwebadmin.model.Client;

@Service
public class ClientService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Client> getClients(String type) {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERMarketPlace/client/type/" + type, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}

	public void deleteClient(String id) {

		restTemplate.delete("http://localhost:8081/ERMarketPlace/client/id/" + id);
		return;
	}

}