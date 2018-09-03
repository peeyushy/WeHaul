package com.erwebadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.erwebadmin.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService service;

	@RequestMapping(value = "/find-client", method = RequestMethod.GET)
	public String findClients(ModelMap model,@RequestParam String type) {		
		model.put("clients", service.getClients(type));
		if(type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");	
		}else {
			model.put("title", "Supplier");
		}
		
		return "find-client";
	}
	
	@RequestMapping(value = "/delete-client", method = RequestMethod.GET)
	public String deleteClient(ModelMap model,@RequestParam String type,@RequestParam String id) {
		//check if user exists then only delete TO-DO
		service.deleteClient(id);
		model.put("clients", service.getClients(type));
		if(type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");	
		}else {
			model.put("title", "Supplier");
		}
		
		return "find-client";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}
}
