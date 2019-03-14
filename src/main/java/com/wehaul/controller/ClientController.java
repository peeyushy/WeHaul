package com.wehaul.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wehaul.constants.AppConstants;
import com.wehaul.model.Client;
import com.wehaul.service.*;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;

	@Autowired
	UserService userService;

	@Autowired
	VehicleTypeService vehicleService;

	@Autowired
	LoadTypeService loadService;

	@Autowired
	RequirementService reqService;

	@RequestMapping(value = "/find-client", method = RequestMethod.GET)
	public String getClientsByType(ModelMap model, @RequestParam String type) {
		model.put("clients", clientService.getClientsByType(type));
		model.put("clientTypeMap", AppConstants.getClientType());
		model.put("cityMap", AppConstants.getCityMap());

		return "find-client";
	}

	@RequestMapping(value = "/search-client", method = RequestMethod.GET)
	public String getAllExceptAdminAndLoggedInClients(ModelMap model, @RequestParam String q) {
		model.put("clients", clientService.getAllActiveExceptLoggedInANDAdminClients(
				userService.getLoggedinUserObj().getClient().getClientid(), q));
		model.put("cityMap", AppConstants.getCityMap());
		model.put("clientTypeMap", AppConstants.getClientType());
		return "find-client";
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String getAllClients(ModelMap model) {
		// Admins see all client status
		model.put("clients", clientService.getAllClients());
		model.put("cityMap", AppConstants.getCityMap());
		model.put("clientTypeMap", AppConstants.getClientType());
		return "find-client";
	}

	@RequestMapping(value = "/delete-client", method = RequestMethod.GET)
	public String deleteClient(ModelMap model, @RequestParam String type, @RequestParam String id,
			final RedirectAttributes redirectAttributes) {
		String msg = "Client " + clientService.getClient(id).getClientname() + " deleted successfully!";
		clientService.deleteClient(id);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/clients";
	}

	@RequestMapping(value = "/add-client", method = RequestMethod.GET)
	public String showAddClientPage(ModelMap model) {
		model.put("action", "Add");
		model.put("client", new Client());
		model.put("clientTypeMap", AppConstants.getClientType());
		model.put("cityMap", AppConstants.getCityMap());
		return "client";
	}

	@RequestMapping(value = "/add-client", method = RequestMethod.POST)
	public String addClient(ModelMap model, @Valid Client client, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		model.put("action", "Add");

		if (result.hasErrors()) {
			return "client";
		} else {
			client.setCreatedby(userService.getLoggedinUserObj().getUsername());
			client.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			clientService.addClient(client);

			redirectAttributes.addFlashAttribute("msg", "Client " + client.getClientname() + " added successfully!");
			return "redirect:/clients";
		}
	}

	@RequestMapping(value = "/edit-client", method = RequestMethod.GET)
	public String showEditClientPage(ModelMap model, @RequestParam String cid) {
		model.put("action", "Edit");
		Client client = clientService.getClient(cid);
		model.put("requirements", reqService.getReqByClientId(cid));
		model.put("clientTypeMap", AppConstants.getClientType());
		model.put("cityMap", AppConstants.getCityMap());
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
			client.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			clientService.updateClient(cid, client);
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("msg", "Client " + client.getClientname() + " updated successfully!");

			return "redirect:/clients";
		}
	}

}
