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

import com.erwebadmin.model.Load;
import com.erwebadmin.model.LoadType;
import com.erwebadmin.service.ClientService;
import com.erwebadmin.service.LoadService;
import com.erwebadmin.service.UserService;

@Controller
public class LoadController {

	@Autowired
	UserService userService;		
	
	@Autowired
	LoadService loadService;
	
	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/delete-load", method = RequestMethod.GET)
	public String deleteLoad(ModelMap model, @RequestParam String cid, @RequestParam String lid,
			final RedirectAttributes redirectAttributes) {
		String msg="Load "+loadService.getLoadById(lid).getLid()+" deleted successfully!";
		loadService.deleteLoad(lid);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/edit-client?cid=" + cid;
	}

	@RequestMapping(value = "/add-load", method = RequestMethod.GET)
	public String showAddLoadPage(ModelMap model, @RequestParam String cid) {
		model.put("action", "Add");
		model.put("cid", cid);
		
		Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
		for (LoadType lType : loadService.getAllActiveLoadType()) {
			lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
		}
		
		model.put("lTypeMap", lTypeMap);
		model.put("load",new Load(clientService.getClient(cid)));
		return "load";
	}

	@RequestMapping(value = "/add-load", method = RequestMethod.POST)
	public String addLoad(ModelMap model, @RequestParam String cid, @Valid Load load, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {			
			Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
			for (LoadType lType : loadService.getAllActiveLoadType()) {
				lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
			}
			model.put("lTypeMap", lTypeMap);
			model.put("action", "Add");
			model.put("cid", cid);
			return "load";
		}else {
			load.setCreatedby(userService.getLoggedinUserObj().getUsername());
			load.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			load.setClient(clientService.getClient(cid));			
			loadService.addLoad(load);		
			redirectAttributes.addFlashAttribute("msg", "Load added successfully!");
			return "redirect:/edit-client?cid=" + cid;
		}		
	}

	@RequestMapping(value = "/edit-load", method = RequestMethod.GET)
	public String showEditLoadPage(ModelMap model, @RequestParam String lid, @RequestParam String cid) {
		model.put("action", "Edit");
		Load load = loadService.getLoadById(lid);		
		
		Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
		for (LoadType lType : loadService.getAllActiveLoadType()) {
			lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
		}		
		model.put("lTypeMap", lTypeMap);

		model.put("selectedlType", load.getLtype());

		model.put("load", load);
		model.put("cid", cid);
		return "load";
	}

	@RequestMapping(value = "/edit-load", method = RequestMethod.POST)
	public String updateLoad(ModelMap model, @RequestParam String cid, @RequestParam String lid, @Valid Load load,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		model.put("action", "Edit");

		if (result.hasErrors()) {
			Map<String, String> lTypeMap = new LinkedHashMap<String, String>();
			for (LoadType lType : loadService.getAllActiveLoadType()) {
				lTypeMap.put(lType.getLtypeid().toString(), lType.getLtypename());
			}		
			model.put("lTypeMap", lTypeMap);

			model.put("selectedlType", load.getLtype());
			model.put("cid", cid);
			return "load";
		} else {
			load.setLastupdatedby(userService.getLoggedinUserObj().getUsername());			
			load.setClient(clientService.getClient(cid));
			loadService.updateLoad(lid, load);
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("msg", "Load "+load.getLid()+" updated successfully!");
			return "redirect:/edit-client?cid=" + cid;
		}
	}
}
