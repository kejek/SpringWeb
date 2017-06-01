package com.mjg.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mjg.model.UserModel;
import com.mjg.persistence.entity.Users;
import com.mjg.service.LoginSrvc;
import com.mjg.service.PasswordSrvc;
import com.mjg.service.UsersSrvc;

@Controller
@ControllerAdvice
@RequestMapping("/")
@SessionAttributes(value = { "savedUser" })
public class CreateUserController {

	@Autowired
	MessageSource messageSource;
	@Autowired
	UsersSrvc usersSrvc;
	@Autowired
	LoginSrvc loginSrvc;
	@Autowired
	PasswordSrvc passwordSrvc;
	@Autowired
	private ModelMapper modelMapper;

	@ModelAttribute("savedUser")
	public UserModel savedUser() {
		return new UserModel();
	}

	@ModelAttribute("newUser")
	public UserModel newUser() {
		return new UserModel();
	}

	@RequestMapping(value = { "/createUser" }, method = RequestMethod.GET)
	public String getCreateUser(@ModelAttribute("savedUser") UserModel savedUser, @ModelAttribute UserModel newUser,
			ModelMap model) {
		if (savedUser.isAuthenticated()) {
			return "redirect:/index";
		} else {
			return "views/createUser.jsp";
		}

	}

	@RequestMapping(value = { "/createUser" }, method = RequestMethod.POST)
	public String createUser(@ModelAttribute UserModel newUser, @ModelAttribute("savedUser") UserModel savedUser,
			ModelMap model, RedirectAttributes redirectAttrs) {

		if (newUser != null) {
			Users userEntity = modelMapper.map(newUser, Users.class);
			if (checkUserName(userEntity.getUserName())) {
				if (checkEmail(userEntity.getEmail())) {
					try {
						// Hash the Password
						userEntity.setPassword(passwordSrvc.hashPassword(userEntity.getPassword()));
						userEntity = usersSrvc.saveUser(userEntity);
					} catch (Exception e) {
						model.addAttribute("errorMsg", "Error: " + e.getLocalizedMessage());
						return "views/createUser.jsp";
					}
					redirectAttrs.addFlashAttribute("successMsg", "Successfully created user.");
					return "redirect:/login";
				} else {
					model.addAttribute("errorMsg", "Email already in use.");
					return "views/createUser.jsp";
				}
			} else {
				model.addAttribute("errorMsg", "Username already in use.");
				return "views/createUser.jsp";
			}
		} else {
			redirectAttrs.addFlashAttribute("errorMsg", "Could not create user.");
			return "redirect:/login";
		}

	}

	private boolean checkUserName(String userName) {
		boolean result = false;
		try {
			Users foundUser = usersSrvc.getUserByUserName(userName);
			if (foundUser == null) {
				result = true;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	private boolean checkEmail(String email) {
		boolean result = false;
		try {
			Users foundUser = usersSrvc.getUserByEmail(email);
			if (foundUser == null) {
				result = true;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
