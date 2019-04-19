package com.wehaul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wehaul.model.Client;

@Service
public class ClientService {
	
	@Value("${webservicebaseurl}")
	private String WS_BASE_URL = null;
	
	@Autowired
	private RestTemplate restTemplate;

	public Client getClient(String id) {

		ResponseEntity<Client> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/client/id/" + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<Client>() {
				});

		return clientResponse.getBody();
	}

	public List<Client> getClientsByType(String type) {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/client/type/" + type,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}

	public List<Client> getAllClients() {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/client/all/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}

	public List<Client> getAllActiveClients() {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/client/all-active/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}

	public List<Client> getAllExceptAdminClients() {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/client/search/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}

	public List<Client> getAllActiveExceptLoggedInANDAdminClients(Long loggedinclientId, String quertStr) {
		String clientIdCommaQueryStr = (loggedinclientId + "," + quertStr).trim();
		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/client/search/" + clientIdCommaQueryStr, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}

	public List<Client> getAllActiveExceptLoggedInANDAdminClients(Long loggedinclientId) {
		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/client/search/" + loggedinclientId.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}

	public void deleteClient(String id) {

		restTemplate.delete(WS_BASE_URL + "/wehaul/client/id/" + id);
		return;
	}

	public void addClient(Client client) {

		HttpEntity<Client> request = new HttpEntity<>(client);
		ResponseEntity<Client> response = restTemplate.exchange(WS_BASE_URL + "/wehaul/client/create", HttpMethod.POST,
				request, Client.class);

		return;
	}

	public void updateClient(String id, Client client) {
		// set created by as its mandatory
		client.setCreatedby(getClient(id).getCreatedby());
		HttpEntity<Client> request = new HttpEntity<>(client);
		ResponseEntity<Client> response = restTemplate.exchange(WS_BASE_URL + "/wehaul/client/id/" + id, HttpMethod.PUT,
				request, Client.class);

		return;
	}
}