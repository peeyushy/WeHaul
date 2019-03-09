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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erwebadmin.model.LoadType;
import com.erwebadmin.model.User;
import com.erwebadmin.model.Vehicle;
import com.erwebadmin.model.VehicleType;
import com.erwebadmin.service.ClientService;
import com.erwebadmin.service.LoadService;
import com.erwebadmin.service.UserService;
import com.erwebadmin.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	UserService userService;

	@Autowired
	ClientService clientService;

	@Autowired
	VehicleService vehicleService;

	@Autowired
	LoadService loadService;

	@RequestMapping(value = "/delete-vehicle", method = RequestMethod.GET)
	public String deleteVehicle(ModelMap model, @RequestParam String vid,
			final RedirectAttributes redirectAttributes) {
		Vehicle vehicle=vehicleService.getVehicleById(vid);
		String msg = "Vehicle " +vehicle.getRegno()  + " deleted successfully!";
		vehicleService.deleteVehicle(vid);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/edit-client?cid=" + vehicle.getClient().getClientid();
	}

	@RequestMapping(value = "/add-vehicle", method = RequestMethod.GET)
	public String showAddVehiclePage(ModelMap model, @RequestParam String cid) {
		model.put("action", "Add");
		model.put("cid", cid);

		Map<String, String> vTypeMap = new LinkedHashMap<String, String>();
		for (VehicleType vehicleType : vehicleService.getAllActiveVehicleType()) {
			vTypeMap.put(vehicleType.getVtypeid().toString(), vehicleType.getVtypename());
		}

		Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
		for (LoadType lType : loadService.getAllActiveLoadType()) {
			lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
		}
		model.put("vTypeMap", vTypeMap);
		model.put("lTypeMap", lTypeMap);
		model.put("vehicle", new Vehicle(clientService.getClient(cid)));
		return "vehicle";
	}

	@RequestMapping(value = "/add-vehicle", method = RequestMethod.POST)
	public String addVehicle(ModelMap model, @RequestParam String cid, @Valid Vehicle vehicle, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			Map<String, String> vTypeMap = new LinkedHashMap<String, String>();
			for (VehicleType vehicleType : vehicleService.getAllActiveVehicleType()) {
				vTypeMap.put(vehicleType.getVtypeid().toString(), vehicleType.getVtypename());
			}

			Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
			for (LoadType lType : loadService.getAllActiveLoadType()) {
				lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
			}
			model.put("vTypeMap", vTypeMap);
			model.put("lTypeMap", lTypeMap);
			return "vehicle";
		} else {
			vehicle.setCreatedby(userService.getLoggedinUserObj().getUsername());
			vehicle.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			vehicle.setClient(clientService.getClient(cid));
			vehicleService.addVehicle(vehicle);
			redirectAttributes.addFlashAttribute("msg",
					"Vehicle reg no : " + vehicle.getRegno() + " added successfully!");
			return "redirect:/edit-client?cid=" + cid;
		}
	}

	@RequestMapping(value = "/edit-vehicle", method = RequestMethod.GET)
	public String showEditVehiclePage(ModelMap model, @RequestParam String vid, @RequestParam String cid) {
		model.put("action", "Edit");
		Vehicle vehicle = vehicleService.getVehicleById(vid);

		Map<String, String> vTypeMap = new LinkedHashMap<String, String>();
		for (VehicleType vehicleType : vehicleService.getAllActiveVehicleType()) {
			vTypeMap.put(vehicleType.getVtypeid().toString(), vehicleType.getVtypename());
		}

		Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
		for (LoadType lType : loadService.getAllActiveLoadType()) {
			lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
		}
		model.put("vTypeMap", vTypeMap);
		model.put("lTypeMap", lTypeMap);

		model.put("selectedvType", vehicle.getVtype().getVtypeid());
		model.put("selectedlType", vehicle.getLtype());

		model.put("vehicle", vehicle);
		model.put("cid", cid);
		return "vehicle";
	}

	@RequestMapping(value = "/edit-vehicle", method = RequestMethod.POST)
	public String updateVehicle(ModelMap model, @RequestParam String cid, @RequestParam String vid, @Valid Vehicle vehicle, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		model.put("action", "Edit");

		if (result.hasErrors()) {
			return "vehicle";
		} else {
			vehicle.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			vehicle.setClient(clientService.getClient(cid));
			vehicleService.updateVehicle(vid, vehicle);
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("msg", "Vehicle " + vehicle.getRegno() + " updated successfully!");
			return "redirect:/edit-client?cid=" + cid;
		}
	}
}
