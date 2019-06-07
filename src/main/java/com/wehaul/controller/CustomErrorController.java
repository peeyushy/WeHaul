package com.wehaul.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	@Autowired
	private ErrorAttributes errorAttributes;

	@Value("${weblinkbaseurl}")
	private String WEBLINK_BASE_URL;

	private static final String PATH = "/error";

	@RequestMapping(PATH)
	public ModelAndView handleException(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		ServletWebRequest servletWebRequest = new ServletWebRequest(request);
		Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(servletWebRequest, true);

		mv.addObject("status", errorAttributes.get("status"));
		mv.addObject("error", errorAttributes.get("error"));

		mv.setViewName("common/noautherror");

		return mv;
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
