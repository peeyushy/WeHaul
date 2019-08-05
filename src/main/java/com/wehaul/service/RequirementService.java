package com.wehaul.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.NestedRuntimeException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.wehaul.dto.QuoteDto;
import com.wehaul.dto.RequirementDto;
import com.wehaul.model.Requirement;

@Service
public class RequirementService {

	private static final Logger log = LoggerFactory.getLogger(RequirementService.class);

	@Value("${webservicebaseurl}")
	private String WS_BASE_URL = null;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ClientService clientService;

	public List<Requirement> getAllReqs() {
		ResponseEntity<List<Requirement>> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/req/all",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Requirement>>() {
				});
		return setClientToReqs(clientResponse.getBody());
	}

	public List<Requirement> getAllReqsByStatus(String status) {
		ResponseEntity<List<Requirement>> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/status/" + status, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Requirement>>() {
				});
		return setClientToReqs(clientResponse.getBody());
	}

	public List<Requirement> getAllReqsByStatusIn(List<String> statusLst) {
		ResponseEntity<List<Requirement>> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/statusin/" + statusLst, HttpMethod.GET, null,
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
		ResponseEntity<Requirement> clientResponse = restTemplate.exchange(WS_BASE_URL + "/wehaul/req/id/" + id,
				HttpMethod.GET, null, new ParameterizedTypeReference<Requirement>() {
				});
		return clientResponse.getBody();
	}

	public List<Requirement> getReqByClientId(String cid) {
		ResponseEntity<List<Requirement>> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/clientid/" + cid, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Requirement>>() {
				});
		return clientResponse.getBody();
	}

	public List<Requirement> getReqByClientIdAndStatus(String cid, List<String> statusLst) {
		ResponseEntity<List<Requirement>> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/byclientidandstatus/" + cid + "/" + statusLst, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Requirement>>() {
				});
		return clientResponse.getBody();
	}

	public Long getClientIdByReqId(String reqid) {
		ResponseEntity<Long> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/getclientidbyreqid/" + reqid, HttpMethod.GET, null,
				new ParameterizedTypeReference<Long>() {
				});
		return clientResponse.getBody();
	}

	public void deleteReq(String id) {
		restTemplate.delete(WS_BASE_URL + "/wehaul/req/id/" + id);
		return;
	}

	public void addReq(Requirement req) {
		HttpEntity<Requirement> request = new HttpEntity<>(req);
		ResponseEntity<Requirement> response = restTemplate.exchange(WS_BASE_URL + "/wehaul/req/create",
				HttpMethod.POST, request, Requirement.class);
		return;
	}
	
	public void updateReq(String reqid, Requirement req) {
		req.setCreatedby(getReqById(reqid).getCreatedby());
		HttpEntity<Requirement> request = new HttpEntity<>(req);
		ResponseEntity<Requirement> response = restTemplate.exchange(WS_BASE_URL + "/wehaul/req/id/" + reqid,
				HttpMethod.PUT, request, Requirement.class);
		return;
	}

	public List<RequirementDto> getAllOpenAndQuotedReqsForClient(String cid)
			throws NestedRuntimeException, UnsupportedEncodingException {
		ResponseEntity<List<RequirementDto>> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/getOpenAndQuotedReq/" + URLEncoder.encode(cid, "UTF-8"), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<RequirementDto>>() {
				});
		return clientResponse.getBody();
	}

	public RequirementDto getReqDetailsByClientIdAndReqId(String cid, String reqid)
			throws RestClientException, UnsupportedEncodingException {
		ResponseEntity<RequirementDto> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/getOpenAndQuotedReq/" + URLEncoder.encode(cid, "UTF-8") + '/' + reqid,
				HttpMethod.GET, null, new ParameterizedTypeReference<RequirementDto>() {
				});
		return clientResponse.getBody();
	}

	public ResponseEntity<Integer> addQuotesToReq(RequirementDto reqdto, String cid)
			throws RestClientException, UnsupportedEncodingException {

		HttpEntity<RequirementDto> request = new HttpEntity<>(reqdto);
		ResponseEntity<Integer> response = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/addquotes/" + URLEncoder.encode(cid, "UTF-8"), HttpMethod.POST, request,
				int.class);
		return response;
	}

	public List<QuoteDto> getLatestQuotesByReqId(String reqid)
			throws NestedRuntimeException, UnsupportedEncodingException {
		ResponseEntity<List<QuoteDto>> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/req/getLatestQuotesByReqId/" + reqid, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<QuoteDto>>() {
				});
		return clientResponse.getBody();
	}
}