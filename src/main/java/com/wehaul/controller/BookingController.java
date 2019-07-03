package com.wehaul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wehaul.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	BookingService bookingService;

	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String getBookingDetails(ModelMap model, @RequestParam String qid) {
		model.put("bookingDetails", bookingService.getBookingDetailsByQId(qid));
		return "bookingdetails";
	}
}
