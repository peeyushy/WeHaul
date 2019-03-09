package com.wehaul.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wehaul.model.Role;
import com.wehaul.model.User;
import com.wehaul.service.ClientService;
import com.wehaul.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(ModelMap model, @RequestParam String cid, @RequestParam String uid,
			final RedirectAttributes redirectAttributes) {
		String msg="User "+userService.getUsersByUserId(uid).getName()+" deleted successfully!";
		userService.deleteUser(uid);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/edit-client?cid=" + cid;
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showAddUserPage(ModelMap model, @RequestParam String cid) {
		model.put("action", "Add");
		Map<String, String> roleMap = new LinkedHashMap<String, String>();
		for (Role role : userService.getAllRoles()) {
			roleMap.put(role.getRoleid().toString(), role.getRolename().toString());
		}
		model.put("roleMap", roleMap);
		model.put("user", new User(clientService.getClient(cid)));
		model.put("cid", cid);
		return "user";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(ModelMap model, @RequestParam String cid, @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "user";
		}else {
			user.setCreatedby(userService.getLoggedinUserObj().getUsername());
			user.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			user.setClient(clientService.getClient(cid));
			userService.addUser(user);		
			redirectAttributes.addFlashAttribute("msg", "User "+user.getName()+" added successfully!");
			return "redirect:/edit-client?cid=" + cid;	
		}		
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.GET)
	public String showEditUserPage(ModelMap model, @RequestParam String cid, @RequestParam String uid) {
		model.put("action", "Edit");
		User user = userService.getUsersByUserId(uid);
		Map<String, String> roleMap = new LinkedHashMap<String, String>();
		roleMap.put(user.getRole().getRoleid().toString(), user.getRole().getRolename().toString());
		model.put("roleMap", roleMap);
		model.put("user", user);
		model.put("cid", cid);
		return "user";
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.POST)
	public String updateUser(ModelMap model, @RequestParam String cid, @RequestParam String uid, @Valid User user,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		model.put("action", "Edit");

		if (result.hasErrors()) {
			return "user";
		} else {
			user.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			user.setClient(clientService.getClient(cid));
			user.setUserid(Long.parseLong(uid));
			userService.updateUser(uid, user);
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("msg", "User "+user.getName()+" updated successfully!");
			return "redirect:/edit-client?cid=" + cid;
		}
	}
}
