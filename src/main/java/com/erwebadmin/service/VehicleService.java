package com.erwebadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erwebadmin.model.Vehicle;
import com.erwebadmin.model.VehicleType;

@Service
public class VehicleService {

	@Autowired
	private RestTemplate restTemplate;

	public Vehicle getVehicleById(String id) {

		ResponseEntity<Vehicle> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/vehicle/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<Vehicle>() {
				});

		return clientResponse.getBody();
	}

	public List<Vehicle> getVehiclesByclientId(String cid) {

		ResponseEntity<List<Vehicle>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/vehicle/clientid/" + cid, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Vehicle>>() {
				});

		return clientResponse.getBody();
	}

	public void deleteVehicle(String id) {
		restTemplate.delete("http://localhost:8081/ERStaticData/vehicle/id/" + id);
		return;
	}

	public void addVehicle(Vehicle vehicle) {

		HttpEntity<Vehicle> request = new HttpEntity<>(vehicle);
		ResponseEntity<Vehicle> response = restTemplate.exchange("http://localhost:8081/ERStaticData/vehicle/create",
				HttpMethod.POST, request, Vehicle.class);

		return;
	}

	public List<VehicleType> getAllVehicleType() {

		ResponseEntity<List<VehicleType>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/vehicletype/all-active", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<VehicleType>>() {
				});

		return clientResponse.getBody();
	}

	public VehicleType getVehicleTypeById(String id) {

		ResponseEntity<VehicleType> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/vehicletype/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<VehicleType>() {
				});

		return clientResponse.getBody();
	}

	public void updateVehicle(String vid, Vehicle vehicle) {
		vehicle.setCreatedby(getVehicleById(vid).getCreatedby());
		HttpEntity<Vehicle> request = new HttpEntity<>(vehicle);
		ResponseEntity<Vehicle> response = restTemplate.exchange("http://localhost:8081/ERStaticData/vehicle/id/" + vid,
				HttpMethod.PUT, request, Vehicle.class);

		return;
	}

}