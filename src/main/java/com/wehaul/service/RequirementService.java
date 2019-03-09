package com.wehaul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wehaul.model.Requirement;

@Service
public class RequirementService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ClientService clientService;

	public List<Requirement> getAllReqs() {
		ResponseEntity<List<Requirement>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/wehaul/req/all", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Requirement>>() {
				});
		return setClientToReqs(clientResponse.getBody());
	}

	public List<Requirement> setClientToReqs(List<Requirement> reqLst) {
		for (Requirement req : reqLst) {
			req.setClient(clientService.getClient(getClientIdByReqId(req.getReqid().toString()).toString()));
		}
		return reqLst;
	}

	public Requirement getReqById(String id) {
		ResponseEntity<Requirement> clientResponse = restTemplate.exchange(
				"http://localhost:8081/wehaul/req/id/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<Requirement>() {
				});
		return clientResponse.getBody();
	}

	public List<Requirement> getReqByClientId(String cid) {
		ResponseEntity<List<Requirement>> clientResponse = restTemplate.exchange(
				"http://localhost:8081/wehaul/req/clientid/" + cid, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Requirement>>() {
				});
		return clientResponse.getBody();
	}

	public Long getClientIdByReqId(String reqid) {
		ResponseEntity<Long> clientResponse = restTemplate.exchange(
				"http://localhost:8081/wehaul/req/getclientidbyreqid/" + reqid, HttpMethod.GET, null,
				new ParameterizedTypeReference<Long>() {
				});
		return clientResponse.getBody();
	}

	public void deleteReq(String id) {
		restTemplate.delete("http://localhost:8081/wehaul/req/id/" + id);
		return;
	}

	public void addReq(Requirement req) {

		HttpEntity<Requirement> request = new HttpEntity<>(req);
		ResponseEntity<Requirement> response = restTemplate.exchange("http://localhost:8081/wehaul/req/create",
				HttpMethod.POST, request, Requirement.class);
		return;
	}

	public void updateReq(String reqid, Requirement req) {
		req.setCreatedby(getReqById(reqid).getCreatedby());
		HttpEntity<Requirement> request = new HttpEntity<>(req);
		ResponseEntity<Requirement> response = restTemplate.exchange(
				"http://localhost:8081/wehaul/req/id/" + reqid, HttpMethod.PUT, request, Requirement.class);
		return;
	}

}