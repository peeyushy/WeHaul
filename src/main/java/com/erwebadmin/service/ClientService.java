package com.erwebadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erwebadmin.model.Client;

@Service
public class ClientService {

	@Autowired
	private RestTemplate restTemplate;

	public Client getClient(String id) {

		ResponseEntity<Client> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/client/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<Client>() {
				});

		return clientResponse.getBody();
	}	

	public List<Client> getClientsByType(String type) {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/client/type/" + type, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}
	
	public List<Client> getAllClients() {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/client/all/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}
	
	public List<Client> getAllExceptAdminAndLoggedInClients() {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/client/search/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}



	public void deleteClient(String id) {

		restTemplate.delete("http://localhost:8081/ERStaticData/client/id/" + id);
		return;
	}

	public void addClient(Client client) {

		HttpEntity<Client> request = new HttpEntity<>(client);
		ResponseEntity<Client> response = restTemplate.exchange("http://localhost:8081/ERStaticData/client/create",
				HttpMethod.POST, request, Client.class);

		return;
	}

	public void updateClient(String id, Client client) {
		// set created by as its mandatory
		client.setCreatedby(getClient(id).getCreatedby());
		HttpEntity<Client> request = new HttpEntity<>(client);
		ResponseEntity<Client> response = restTemplate.exchange("http://localhost:8081/ERStaticData/client/id/" + id,
				HttpMethod.PUT, request, Client.class);

		return;
	}
}