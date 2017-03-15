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
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.mjg.model.Question;
import com.mjg.service.Problems;
import com.mjg.utils.StringUtils;

@Controller
@ControllerAdvice
@RequestMapping("/")
public class AppController {

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	Problems problem;

	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String getHome(@ModelAttribute Question question, ModelMap model) {
		return "views/index.jsp";
	}
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.POST)
	public String getSumItUp(@ModelAttribute Question question,ModelMap model) {
		String error = null;
		int answer = 0;
		try {
			int[] ints = StringUtils.StringArrayToIntArray(question.getValue().split(","));
			answer = problem.SumItUp(ints);
		} catch (Exception e) {
			error = "Unable to retreive answer. Please check your entered values.";
		}
		if (error != null){
			model.addAttribute("answer",error);
		}
		else{
			model.addAttribute("answer", answer);
		}
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
