package com.wehaul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wehaul.model.VehicleType;

@Service
public class VehicleTypeService {
	
	@Value("${webservicebaseurl}")
	private String WS_BASE_URL = null;

	@Autowired
	private RestTemplate restTemplate;

	public List<VehicleType> getAllActiveVehicleType() {

		ResponseEntity<List<VehicleType>> clientResponse = restTemplate.exchange(
				WS_BASE_URL+"/wehaul/vehicletype/all-active", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<VehicleType>>() {
				});

		return clientResponse.getBody();
	}

	public VehicleType getVehicleTypeById(String id) {

		ResponseEntity<VehicleType> clientResponse = restTemplate.exchange(
				WS_BASE_URL+"/wehaul/vehicletype/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<VehicleType>() {
				});

		return clientResponse.getBody();
	}

}