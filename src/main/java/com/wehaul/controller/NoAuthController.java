package com.wehaul.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wehaul.dto.RequirementDto;
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
	public String showPublicRequirementPage(ModelMap model, @RequestParam String cid) {
		try {
			model.put("openandquotedrequirements", reqService.getAllOpenAndQuotedReqsForClient(cid));
			model.put("cid", cid);
		} catch (NestedRuntimeException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "noauth/publicrequirements";
	}

	@RequestMapping(value = "/noauth/sendquotes", method = RequestMethod.GET)
	public String showGetQuotesPage(ModelMap model, @RequestParam String cid, @RequestParam String reqid) {
		RequirementDto requirement;
		try {
			requirement = reqService.getReqDetailsByClientIdAndReqId(cid, reqid);
			model.put("requirement", requirement);
			model.put("cid", cid);
		} catch (RestClientException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "noauth/sendquote";
	}

	@RequestMapping(value = "/noauth/sendquotes", method = RequestMethod.POST)
	public String addQuotes(ModelMap model, @RequestParam String cid, @RequestParam String reqid,
			@Valid @ModelAttribute("requirement") RequirementDto requirementDto, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "noauth/sendquote";
		} else {
			// Save quotes
			try {
				reqService.addQuotesToReq(requirementDto, cid);
				redirectAttributes.addFlashAttribute("msg",
						"Thank you for your quote. We will contact you as soon as we have a match.");
				cid = URLEncoder.encode(cid, "UTF-8");
			} catch (RestClientException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "redirect:/noauth?cid=" + cid;
		}
	}
}
