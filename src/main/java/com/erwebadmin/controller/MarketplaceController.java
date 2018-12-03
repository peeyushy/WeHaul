package com.erwebadmin.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erwebadmin.model.Load;
import com.erwebadmin.model.LoadType;
import com.erwebadmin.model.VehicleType;
import com.erwebadmin.service.ClientService;
import com.erwebadmin.service.LoadService;
import com.erwebadmin.service.VehicleService;

@Controller
public class MarketplaceController {

	@Autowired
	LoadService loadService;

	@Autowired
	VehicleService vehicleService;

	@Autowired
	ClientService clientService;	

	@RequestMapping(value = "/get-load", method = RequestMethod.GET)
	public String showGetLoadPage(ModelMap model) {		
		Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
		for (LoadType lType : loadService.getAllActiveLoadType()) {
			lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
		}		
		model.put("lTypeMap", lTypeMap);
		model.put("load", new Load());
		return "get-load";
	}
	
	@RequestMapping(value = "/get-vehicle", method = RequestMethod.GET)
	public String showGetVehiclePage(ModelMap model) {
		Map<String, String> vTypeMap = new LinkedHashMap<String, String>();
		for (VehicleType vehicleType : vehicleService.getAllActiveVehicleType()) {
			vTypeMap.put(vehicleType.getVtypeid().toString(), vehicleType.getVtypename());
		}

		model.put("vTypeMap", vTypeMap);

		return "get-vehicle";
	}
}
