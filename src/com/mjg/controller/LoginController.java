package com.mjg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.mjg.model.UserModel;
import com.mjg.service.LoginSrvc;
import com.mjg.service.PasswordSrvc;
import com.mjg.service.UsersSrvc;

@Controller
@ControllerAdvice
@RequestMapping("/")
@SessionAttributes(value = { "savedUser" })
public class LoginController {

	@Autowired
	MessageSource messageSource;
	@Autowired
	UsersSrvc usersSrvc;
	@Autowired
	LoginSrvc loginSrvc;
	@Autowired
	PasswordSrvc passwordSrvc;


	@ModelAttribute("savedUser")
	public UserModel savedUser() {
		return new UserModel();
	}

	@ModelAttribute("newUser")
	public UserModel newUser() {
		return new UserModel();
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getHome(@ModelAttribute UserModel user, @ModelAttribute("savedUser") UserModel savedUser,
			ModelMap model) {
		if (savedUser.isAuthenticated()) {
			return "redirect:/index";
		} else {
			return "views/login.jsp";
		}

	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String getLogin(@ModelAttribute UserModel user, @ModelAttribute("savedUser") UserModel savedUser,
			ModelMap model) {
		savedUser = loginSrvc.login(user.getUserName(), user.getPassword());
		if (savedUser.isAuthenticated()) {
			model.addAttribute("savedUser", savedUser);
			return "redirect:/index";
		} else {
			model.addAttribute("loginError", "Login failed.");

			return "views/login.jsp";
		}

	}

	@RequestMapping("/logout")
	public String logout(ModelMap model, SessionStatus sessionStatus) {
		// Set session complete. Clears all session variables.
		sessionStatus.setComplete();

		return "redirect:/login";

	}

}
