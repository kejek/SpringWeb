package com.mjg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.mjg.model.UserModel;

@Controller
@ControllerAdvice
@RequestMapping("/")
@SessionAttributes(value = { "savedUser" })
public class AppController {

	@Autowired
	MessageSource messageSource;

	@ModelAttribute("savedUser")
	public UserModel savedUser() {
		return new UserModel();
	}

	@ModelAttribute("user")
	public UserModel user() {
		return new UserModel();
	}

	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("savedUser") UserModel savedUser, ModelMap model) {
		if (savedUser.isAuthenticated()) {
			return "views/index.jsp";
		} else {
			return "redirect:/login";
		}

	}

	@SuppressWarnings("unused")
	@RequestMapping(value = { "/*" })
	public String catchAllUrl(HttpServletRequest request) throws NoSuchRequestHandlingMethodException {
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
