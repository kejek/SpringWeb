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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.mjg.aspect.Loggable;
import com.mjg.model.User;
import com.mjg.service.Login;

@Controller
@ControllerAdvice
@RequestMapping("/")
@SessionAttributes(value = { "user", "savedUser" })
public class AppController {

	@Autowired
	MessageSource messageSource;
	@Autowired
	Login login;

	@ModelAttribute("savedUser")
	public User savedUser() {
		return new User();
	}

	@ModelAttribute("user")
	public User user() {
		return new User();
	}

	@Loggable
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getHome(@ModelAttribute User user, @ModelAttribute("savedUser") User savedUser, ModelMap model) {
		if (savedUser.isAuthenticated()) {
			return "redirect:/index";
		} else {
			return "views/login.jsp";
		}

	}

	@Loggable
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String getSumItUp(@ModelAttribute User user, @ModelAttribute("savedUser") User savedUser, ModelMap model) {
		if (login.login(user.getUserName(), user.getPassword())) {
			savedUser = user;
			savedUser.setAuthenticated(true);
			model.addAttribute("savedUser", savedUser);
			return "redirect:/index";
		} else {
			model.addAttribute("loginError", "Failed to login. Login is test/test. :P ");

			return "views/login.jsp";
		}

	}

	@Loggable
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String getIndex(@ModelAttribute User user, @ModelAttribute("savedUser") User savedUser, ModelMap model) {
		if (savedUser.isAuthenticated()) {
			return "views/index.jsp";
		} else {
			return "redirect:/login";
		}

	}

	@Loggable
	@RequestMapping(value = { "/netflix" }, method = RequestMethod.GET)
	public String getNetflix(@ModelAttribute User user, @ModelAttribute("savedUser") User savedUser, ModelMap model) {
		if (savedUser.isAuthenticated()) {
			return "views/netflix.jsp";
		} else {
			return "redirect:/login";
		}

	}

	@Loggable
	@RequestMapping("/logout")
	public String logout(ModelMap model, SessionStatus sessionStatus) {
		// Set session complete. Clears all session variables.
		sessionStatus.setComplete();

		return "redirect:/login";

	}

	@Loggable
	@SuppressWarnings("unused")
	@RequestMapping(value = { "/*" })
	public String catchAllUrl(HttpServletRequest request) throws NoSuchRequestHandlingMethodException {
		if (true) {
			throw new NoSuchRequestHandlingMethodException(request);
		}
		return null;
	}

	@Loggable
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
