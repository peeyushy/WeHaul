package com.erwebadmin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erwebadmin.model.Client;
import com.erwebadmin.service.ClientService;
import com.erwebadmin.service.UserService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/find-client", method = RequestMethod.GET)
	public String findClients(ModelMap model, @RequestParam String type) {
		model.put("clients", clientService.getClients(type));
		if (type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");
		} else {
			model.put("title", "Supplier");
		}

		return "find-client";
	}

	@RequestMapping(value = "/delete-client", method = RequestMethod.GET)
	public String deleteClient(ModelMap model, @RequestParam String type, @RequestParam String id,
			final RedirectAttributes redirectAttributes) {
		String msg="Client "+clientService.getClient(id).getClientname()+" deleted successfully!";
		clientService.deleteClient(id);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/find-client?type="+type;
	}

	@RequestMapping(value = "/add-client", method = RequestMethod.GET)
	public String showAddClientPage(ModelMap model, @RequestParam String type) {
		model.put("action", "Add");
		model.put("client", new Client(type));
		if (type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");
		} else {
			model.put("title", "Supplier");
		}

		return "client";
	}

	@RequestMapping(value = "/add-client", method = RequestMethod.POST)
	public String addClient(ModelMap model, @Valid Client client, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		model.put("action", "Add");		

		if (result.hasErrors()) {
			return "client";
		}else {
			client.setCreatedby(userService.getLoggedinUserName());
			client.setLastupdatedby(userService.getLoggedinUserName());
			clientService.addClient(client);			
			
			redirectAttributes.addFlashAttribute("msg", "Client "+client.getClientname()+" added successfully!");
			return "redirect:/find-client?type="+client.getClienttype();
		}
	}

	@RequestMapping(value = "/edit-client", method = RequestMethod.GET)
	public String showEditClientPage(ModelMap model, @RequestParam String cid) {
		model.put("action", "Edit");
		Client client = clientService.getClient(cid);
		if (client.getClienttype() != null && client.getClienttype().equalsIgnoreCase("T")) {
			model.put("title", "Transporter");
		} else {
			model.put("title", "Supplier");
		}
		model.put("client", client);
		return "client";
	}

	@RequestMapping(value = "/edit-client", method = RequestMethod.POST)
	public String updateClient(ModelMap model, @RequestParam String cid, @Valid Client client, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		model.put("action", "Edit");
		
		if (result.hasErrors()) {
			return "client";
		} else {
			client.setLastupdatedby(userService.getLoggedinUserName());
			clientService.updateClient(cid, client);
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("msg", "Client "+client.getClientname()+" updated successfully!");

			model.put("clients", clientService.getClients(client.getClienttype()));
			return "redirect:/find-client?type=" + client.getClienttype();
		}
	}

}
