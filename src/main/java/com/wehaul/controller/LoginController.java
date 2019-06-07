package com.wehaul.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String root() {
		return "index";
	}

	@RequestMapping(value = "/home", method = { RequestMethod.POST, RequestMethod.GET })
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

}
