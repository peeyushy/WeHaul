package com.erwebadmin.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erwebadmin.dto.LoadSearchOptionsDto;
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

		Map<String, String> vTypeMap = new LinkedHashMap<String, String>();
		for (VehicleType vehicleType : vehicleService.getAllActiveVehicleType()) {
			vTypeMap.put(vehicleType.getVtypeid().toString(), vehicleType.getVtypename());
		}

		model.put("vTypeMap", vTypeMap);

		model.put("loadSearchOptionsDto", new LoadSearchOptionsDto());
		return "get-load";
	}

	@RequestMapping(value = "/get-load", method = RequestMethod.POST)
	public String getLoad(ModelMap model, @Valid LoadSearchOptionsDto loadSearchOptionsDto, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			Map<String, String> vTypeMap = new LinkedHashMap<String, String>();
			for (VehicleType vehicleType : vehicleService.getAllActiveVehicleType()) {
				vTypeMap.put(vehicleType.getVtypeid().toString(), vehicleType.getVtypename());
			}
			model.put("vTypeMap", vTypeMap);
			model.put("loadSearchOptionsDto", loadSearchOptionsDto);
			return "get-load";
		} else {
			model.put("LoadSearchResults", loadService.getLoadBySearchOptions(loadSearchOptionsDto));
			Map<String, String> vTypeMap = new LinkedHashMap<String, String>();
			for (VehicleType vehicleType : vehicleService.getAllActiveVehicleType()) {
				vTypeMap.put(vehicleType.getVtypeid().toString(), vehicleType.getVtypename());
			}
			model.put("vTypeMap", vTypeMap);
			model.put("selectedvType", loadSearchOptionsDto.getVehicle().getVtype().getVtypeid());
			// Add message to flash scope
			// redirectAttributes.addFlashAttribute("msg", "Load "+load.getLid()+" updated
			// successfully!");
			return "get-load";
		}
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
