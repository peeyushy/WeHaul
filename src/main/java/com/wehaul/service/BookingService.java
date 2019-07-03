package com.wehaul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wehaul.dto.BookingDto;

@Service
public class BookingService {

	@Value("${webservicebaseurl}")
	private String WS_BASE_URL = null;

	@Autowired
	private RestTemplate restTemplate;

	public BookingDto getBookingDetailsByQId(String qid) {
		ResponseEntity<BookingDto> clientResponse = restTemplate.exchange(
				WS_BASE_URL + "/wehaul/booking/getBookingByQuoteId/" + qid, HttpMethod.GET, null,
				new ParameterizedTypeReference<BookingDto>() {
				});
		return clientResponse.getBody();
	}

}