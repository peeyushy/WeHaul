package com.erwebadmin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.erwebadmin.model.Client;
import com.erwebadmin.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService service;

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/find-client", method = RequestMethod.GET)
	public String findClients(ModelMap model, @RequestParam String type) {
		model.put("clients", service.getClients(type));
		if (type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");
		} else {
			model.put("title", "Supplier");
		}

		return "find-client";
	}

	@RequestMapping(value = "/delete-client", method = RequestMethod.GET)
	public String deleteClient(ModelMap model, @RequestParam String type, @RequestParam String id) {
		// check if user exists then only delete TO-DO
		service.deleteClient(id);
		model.put("clients", service.getClients(type));
		if (type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");
		} else {
			model.put("title", "Supplier");
		}

		return "find-client";
	}

	@RequestMapping(value = "/add-client", method = RequestMethod.GET)
	public String showAddClientPage(ModelMap model, @RequestParam String type) {
		model.put("client", new Client());
		if (type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");
		} else {
			model.put("title", "Supplier");
		}

		return "add-client";
	}

	@RequestMapping(value = "/add-client", method = RequestMethod.POST)
	public String addClient(ModelMap model, @RequestParam String type, @Valid Client client, BindingResult result) {
		if (type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");
		} else {
			model.put("title", "Supplier");
		}

		if (result.hasErrors()) {
			return "add-client";
		}
		client.setCreatedby(getLoggedInUserName(model));
		client.setLastupdatedby(getLoggedInUserName(model));
		client.setClienttype(type);
		service.addClient(client);

		model.put("clients", service.getClients(type));
		return "find-client";
	}
}
