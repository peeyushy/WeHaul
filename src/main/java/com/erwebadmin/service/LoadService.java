package com.erwebadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erwebadmin.model.LoadType;
import com.erwebadmin.model.Vehicle;

@Service
public class LoadService {

	@Autowired
	private RestTemplate restTemplate;

	public Vehicle getLoadById(String id) {

		ResponseEntity<Vehicle> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/vehicle/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<Vehicle>() {
				});

		return clientResponse.getBody();
	}

	public void deleteLoad(String id) {
		restTemplate.delete("http://localhost:8081/ERStaticData/vehicle/id/" + id);
		return;
	}

	public void addLoad(Vehicle vehicle) {

		HttpEntity<Vehicle> request = new HttpEntity<>(vehicle);
		ResponseEntity<Vehicle> response = restTemplate.exchange("http://localhost:8081/ERStaticData/vehicle/create",
				HttpMethod.POST, request, Vehicle.class);

		return;
	}

	public List<LoadType> getAllActiveLoadType() {

		ResponseEntity<List<LoadType>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/loadtype/all-active", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<LoadType>>() {
				});

		return clientResponse.getBody();
	}

	/*
	 * public void updateVehicle(String id, Vehicle user) {
	 * user.setCreatedby(getUsersByUserId(id).getCreatedby()); HttpEntity<User>
	 * request = new HttpEntity<>(user); ResponseEntity<User> response =
	 * restTemplate.exchange("http://localhost:8081/ERStaticData/vehicle/id/" + id,
	 * HttpMethod.PUT, request, User.class);
	 * 
	 * return; }
	 */
}