package com.mjg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
@ControllerAdvice
@RequestMapping("/")
public class AppController {

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String getHome() {
		return "views/index.jsp";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = { "/*" })
	public String catchAllUrl(HttpServletRequest request)
			throws NoSuchRequestHandlingMethodException {
		if (true) {
			throw new NoSuchRequestHandlingMethodException(request);
		}
		return null;
	}

	@ExceptionHandler(NoSuchRequestHandlingMethodException.class)
	public String handlePageNotFound(HttpServletRequest request) {
		// this will return you the original URL for which this 404 happened
		/*
		 * String originalUri = (String) request
		 * .getAttribute("javax.servlet.forward.request_uri");
		 */

		// here you can write your code to handle this 404 error
		return "views/notFound.jsp";
	}
}
