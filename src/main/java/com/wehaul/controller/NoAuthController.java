package com.wehaul.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class NoAuthController {

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

	@RequestMapping(value = "/noauth", method = RequestMethod.GET)
	public String showNoAuthPage(ModelMap model) {
		
		model.put("openandquotedrequirements", reqService.getAllReqsByStatusIn(ReqStatus.OPEN.toString()+"#"+ReqStatus.QUOTED.toString()));
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

		return "noauth/get-quotes";
	}
}
