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

import com.erwebadmin.model.User;
import com.erwebadmin.service.ClientService;
import com.erwebadmin.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ClientService clientService;

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	/*@RequestMapping(value = "/find-user", method = RequestMethod.GET)
	public String findClients(ModelMap model, @RequestParam String type) {
		model.put("clients", userService.getClients(type));
		if (type.equalsIgnoreCase("T")) {
			model.put("title", "Transporter");
		} else {
			model.put("title", "Supplier");
		}

		return "find-client";
	}
*/
	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(ModelMap model, @RequestParam String cid, @RequestParam String uid) {
		userService.deleteUser(uid);
		return "redirect:/edit-client?cid="+cid;	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showAddUserPage(ModelMap model, @RequestParam String cid) {
		model.put("action", "Add");
		model.put("user", new User(Long.parseLong(cid)));	

		return "user";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(ModelMap model, @RequestParam String cid, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user";
		}
		user.setCreatedby(getLoggedInUserName(model));
		user.setLastupdatedby(getLoggedInUserName(model));
		user.setClientid(Long.parseLong(cid));
		userService.addUser(user);
		return "redirect:/edit-client?cid="+cid;
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.GET)
	public String showEditUserPage(ModelMap model, @RequestParam String uid) {
		model.put("action", "Edit");		
		model.put("user", userService.getUsersByUserId(uid));
		return "user";
	}
	
	@RequestMapping(value = "/edit-user", method = RequestMethod.POST)
	public String updateUser(ModelMap model, @RequestParam String cid, @RequestParam String uid, @Valid User user, BindingResult result) {
		model.put("action", "Edit");
		
		if (result.hasErrors()) {
			return "user";
		}
		
		user.setLastupdatedby(getLoggedInUserName(model));
		user.setClientid(Long.parseLong(cid));
		user.setUserid(Long.parseLong(uid));
		userService.updateUser(uid,user);

		return "redirect:/edit-client?cid="+cid;

	}

}
