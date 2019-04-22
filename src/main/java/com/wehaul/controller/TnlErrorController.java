package com.wehaul.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TnlErrorController {

	@Value("${weblinkbaseurl}")
	private String WEBLINK_BASE_URL;
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("exception", ex.getLocalizedMessage());
		mv.addObject("url", request.getRequestURL());
		if (request.getRequestURL().indexOf(WEBLINK_BASE_URL) == -1) {
			// authenticated user
			mv.setViewName("common/error");
		} else {
			mv.setViewName("common/noautherror");
		}
		return mv;
	}
}
