package com.wehaul.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wehaul.constants.AppConstants;
import com.wehaul.constants.ReqStatus;
import com.wehaul.dto.QuoteDto;
import com.wehaul.model.LoadType;
import com.wehaul.model.Requirement;
import com.wehaul.model.VehicleType;
import com.wehaul.service.ClientService;
import com.wehaul.service.LoadTypeService;
import com.wehaul.service.RequirementService;
import com.wehaul.service.UserService;
import com.wehaul.service.VehicleTypeService;

@Controller
public class ReqirementController {

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

	@RequestMapping(value = "/req", method = RequestMethod.GET)
	public String getAllRequirments(ModelMap model) {
		if (userService.getLoggedinUserObj().getRole().getRolename().equals(AppConstants.RoleNames.ADMIN)) {
			model.put("requirements", reqService.getAllReqs());
		} else {
			model.put("requirements",
					reqService.getReqByClientId(userService.getLoggedinUserObj().getClient().getClientid().toString()));
		}

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

		return "find-requirements";
	}

	@RequestMapping(value = "/delete-req", method = RequestMethod.GET)
	public String deleteReq(ModelMap model, @RequestParam String reqid, final RedirectAttributes redirectAttributes) {
		reqService.deleteReq(reqid);
		redirectAttributes.addFlashAttribute("msg", "Requirement deleted successfully!");
		return "redirect:/req";
	}

	@RequestMapping(value = "/add-req", method = RequestMethod.GET)
	public String getAddReqPage(ModelMap model) {
		model.put("action", "Add");
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

		model.put("requirement", new Requirement(ReqStatus.NEW));
		return "requirement";
	}

	@RequestMapping(value = "/add-req", method = RequestMethod.POST)
	public String postAddReqPage(ModelMap model, @Valid Requirement req, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.put("action", "Add");
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

			return "requirement";
		} else {
			String username = userService.getLoggedinUserObj().getUsername();
			req.setCreatedby(username);
			req.setLastupdatedby(username);
			req.setClient(userService.getLoggedinUserObj().getClient());
			req.setStatus(ReqStatus.NEW);
			reqService.addReq(req);
			redirectAttributes.addFlashAttribute("msg", "Requirement added successfully!");
			return "redirect:/req";
		}
	}

	@RequestMapping(value = "/add-client-req", method = RequestMethod.GET)
	public String getAddReqPage(ModelMap model, @RequestParam String cid) {
		model.put("action", "Add");

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

		model.put("requirement", new Requirement(ReqStatus.NEW));
		model.put("cid", cid);
		return "requirement";
	}

	@RequestMapping(value = "/add-client-req", method = RequestMethod.POST)
	public String postAddClientReqPage(ModelMap model, @Valid Requirement req, @RequestParam String cid,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.put("action", "Add");
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
			model.put("cid", cid);
			return "requirement";
		} else {
			String username = userService.getLoggedinUserObj().getUsername();
			req.setCreatedby(username);
			req.setLastupdatedby(username);
			req.setClient(clientService.getClient(cid));
			req.setStatus(ReqStatus.NEW);
			reqService.addReq(req);
			redirectAttributes.addFlashAttribute("msg", "Requirement added successfully!");
			return "redirect:/edit-client?cid=" + cid;
		}
	}

	@RequestMapping(value = "/edit-client-req", method = RequestMethod.GET)
	public String getEditClientReqPage(ModelMap model, @RequestParam String cid, @RequestParam String reqid) {
		model.put("action", "Edit");
		Requirement req = reqService.getReqById(reqid);
		List<QuoteDto> quotesLst = new ArrayList<QuoteDto>();
		try {
			quotesLst = reqService.getLatestQuotesByReqId(reqid);
		} catch (NestedRuntimeException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.put("reqTypeMap", AppConstants.getReqTypeMap());
		model.put("selectedReqType", req.getReqtype());

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

		model.put("selectedvType", req.getVtype());
		model.put("selectedlType", req.getLtype());
		model.put("cid", cid);
		model.put("requirement", req);
		model.put("quotes", quotesLst);
		return "requirement";
	}

	@RequestMapping(value = "/edit-client-req", method = RequestMethod.POST)
	public String postEditClientReqPage(ModelMap model, @RequestParam String cid, @RequestParam String reqid,
			@Valid Requirement req, BindingResult result, final RedirectAttributes redirectAttributes) {
		model.put("action", "Edit");

		if (result.hasErrors()) {
			model.put("reqTypeMap", AppConstants.getReqTypeMap());
			model.put("selectedReqType", req.getReqtype());

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

			model.put("selectedvType", req.getVtype());
			model.put("selectedlType", req.getLtype());
			model.put("cid", cid);
			return "requirement";
		} else {
			req.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			req.setClient(clientService.getClient(reqService.getClientIdByReqId(reqid).toString()));
			// no status update from UI
			req.setStatus(reqService.getReqById(reqid).getStatus());
			reqService.updateReq(reqid, req);
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("msg", "Requirement updated successfully!");
			return "redirect:/edit-client?cid=" + cid;
		}
	}

	@RequestMapping(value = "/edit-req", method = RequestMethod.GET)
	public String getEditReqPage(ModelMap model, @RequestParam String reqid) {
		model.put("action", "Edit");
		Requirement req = reqService.getReqById(reqid);
		List<QuoteDto> quotesLst = new ArrayList<QuoteDto>();
		try {
			quotesLst = reqService.getLatestQuotesByReqId(reqid);
		} catch (NestedRuntimeException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.put("reqTypeMap", AppConstants.getReqTypeMap());
		model.put("selectedReqType", req.getReqtype());

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

		model.put("selectedvType", req.getVtype());
		model.put("selectedlType", req.getLtype());

		model.put("requirement", req);
		model.put("quotes", quotesLst);
		return "requirement";
	}

	@RequestMapping(value = "/edit-req", method = RequestMethod.POST)
	public String postEditReqPage(ModelMap model, @RequestParam String reqid, @Valid Requirement req,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		model.put("action", "Edit");

		if (result.hasErrors()) {
			model.put("reqTypeMap", AppConstants.getReqTypeMap());
			model.put("selectedReqType", req.getReqtype());

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

			model.put("selectedvType", req.getVtype());
			model.put("selectedlType", req.getLtype());

			return "requirement";
		} else {
			req.setLastupdatedby(userService.getLoggedinUserObj().getUsername());
			req.setClient(clientService.getClient(reqService.getClientIdByReqId(reqid).toString()));
			// no status update from UI
			req.setStatus(reqService.getReqById(reqid).getStatus());
			reqService.updateReq(reqid, req);
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("msg", "Requirement updated successfully!");
			return "redirect:/req";
		}
	}
}
