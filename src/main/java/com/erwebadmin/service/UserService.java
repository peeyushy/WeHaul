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
import com.erwebadmin.model.User;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;

	public List<User> getUsersByClientId(String id) {

		ResponseEntity<List<User>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERMarketPlace/user/client/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});

		return clientResponse.getBody();
	}
	
	public User getUsersByUserId(String id) {

		ResponseEntity<User> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERMarketPlace/user/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<User>() {
				});

		return clientResponse.getBody();
	}


	/*public List<Client> getClients(String type) {

		ResponseEntity<List<Client>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERMarketPlace/client/type/" + type, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				});

		return clientResponse.getBody();
	}
*/
	public void deleteUser(String id) {
		restTemplate.delete("http://localhost:8081/ERMarketPlace/user/id/" + id);
		return;
	}

	public void addUser(User user) {

		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = restTemplate.exchange("http://localhost:8081/ERMarketPlace/user/create",
				HttpMethod.POST, request, User.class);

		return;
	}

	public void updateUser(String id, User user) {
		user.setCreatedby(getUsersByUserId(id).getCreatedby());
		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = restTemplate.exchange("http://localhost:8081/ERMarketPlace/user/id/" + id,
				HttpMethod.PUT, request, User.class);

		return;
	}

}