package com.erwebadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erwebadmin.dto.LoadSearchOptionsDto;
import com.erwebadmin.model.Load;
import com.erwebadmin.model.LoadType;

@Service
public class LoadService {

	@Autowired
	private RestTemplate restTemplate;

	public Load getLoadById(String id) {

		ResponseEntity<Load> clientResponse = restTemplate.exchange("http://localhost:8081/ERStaticData/load/id/" + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<Load>() {
				});

		return clientResponse.getBody();
	}

	public void deleteLoad(String id) {
		restTemplate.delete("http://localhost:8081/ERStaticData/load/id/" + id);
		return;
	}

	public void addLoad(Load load) {

		HttpEntity<Load> request = new HttpEntity<>(load);
		ResponseEntity<Load> response = restTemplate.exchange("http://localhost:8081/ERStaticData/load/create",
				HttpMethod.POST, request, Load.class);

		return;
	}

	public List<LoadType> getAllActiveLoadType() {

		ResponseEntity<List<LoadType>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/loadtype/all-active", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<LoadType>>() {
				});

		return clientResponse.getBody();
	}

	public List<Load> getLoadByClientId(String cid) {

		ResponseEntity<List<Load>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/load/clientid/" + cid, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Load>>() {
				});

		return clientResponse.getBody();
	}

	public List<Load> getLoadByVehicleId(String vid) {

		ResponseEntity<List<Load>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/load/vehicleid/" + vid, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Load>>() {
				});

		return clientResponse.getBody();
	}

	public List<Load> getLoadBySearchOptions(LoadSearchOptionsDto loadSearchOptions) {
		HttpEntity<LoadSearchOptionsDto> request = new HttpEntity<>(loadSearchOptions);
		ResponseEntity<List<Load>> response = restTemplate.exchange(
				"http://localhost:8081/ERStaticData/load/searchoptions/", HttpMethod.POST, request,
				new ParameterizedTypeReference<List<Load>>() {
				});

		return response.getBody();
	}

	public void updateLoad(String lid, Load load) {
		load.setCreatedby(getLoadById(lid).getCreatedby());
		HttpEntity<Load> request = new HttpEntity<>(load);
		ResponseEntity<Load> response = restTemplate.exchange("http://localhost:8081/ERStaticData/load/id/" + lid,
				HttpMethod.PUT, request, Load.class);

		return;
	}

}