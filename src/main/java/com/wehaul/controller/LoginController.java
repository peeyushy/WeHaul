package com.wehaul.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wehaul.constants.AppConstants;
import com.wehaul.constants.ReqStatus;
import com.wehaul.model.LoadType;
import com.wehaul.model.VehicleType;
import com.wehaul.service.ClientService;
import com.wehaul.service.LoadTypeService;
import com.wehaul.service.RequirementService;
import com.wehaul.service.UserService;
import com.wehaul.service.VehicleTypeService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	RequirementService reqService;

	@Autowired
	ClientService clientService;

	@Autowired
	VehicleTypeService vehicleService;

	@Autowired
	LoadTypeService loadTypeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", userService.getLoggedinUserObj().getUsername());
		List<String> quotedstatusLst = new ArrayList<String>();
		quotedstatusLst.add(ReqStatus.QUOTED.toString());
		if (userService.getLoggedinUserObj().getRole().getRolename().equals(AppConstants.RoleNames.ADMIN)) {
			model.put("quotedrequirements", reqService.getAllReqsByStatus(ReqStatus.QUOTED.toString()));
		} else {
			model.put("quotedrequirements", reqService.getReqByClientIdAndStatus(
					userService.getLoggedinUserObj().getClient().getClientid().toString(), quotedstatusLst));
		}
		List<String> openAndQuotedstatusLst = new ArrayList<String>();
		openAndQuotedstatusLst.add(ReqStatus.OPEN.toString());
		openAndQuotedstatusLst.add(ReqStatus.QUOTED.toString());
		model.put("openandquotedrequirements", reqService.getAllReqsByStatusIn(openAndQuotedstatusLst));
		model.put("reqTypeMap", AppConstants.getReqTypeMap());

		Map<String, String> vTypeMap = new LinkedHashMap<String, String>();
		for (VehicleType vehicleType : vehicleService.getAllActiveVehicleType()) {
			vTypeMap.put(vehicleType.getVtypeid().toString(), vehicleType.getVtypename());
		}

		Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
		for (LoadType lType : loadTypeService.getAllActiveLoadType()) {
			lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
		}
		model.put("vTypeMap", vTypeMap);
		model.put("lTypeMap", lTypeMap);

		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}

		return "redirect:/";
	}
}
