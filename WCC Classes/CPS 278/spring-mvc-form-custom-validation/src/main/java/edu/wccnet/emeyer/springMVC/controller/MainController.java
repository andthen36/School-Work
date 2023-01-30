package edu.wccnet.emeyer.springMVC.controller;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.wccnet.emeyer.springMVC.domain.Customer;
import edu.wccnet.emeyer.springMVC.domain.Pet;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
		
	
	@RequestMapping("/showForm")
	public String showForm() {
		@ModelAttribute("pet") Pet pet) {
		return new ModelAndView("info-form","customer",new Customer());
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "info-form";
		}else {
		return "confirmation";
		}
	}
	@InitBinder
	public void initialBinderForTrimmingSpaces(WebDataBinder webDataBinder) {
	    StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
	    webDataBinder.registerCustomEditor(String.class, stringTrimEditor);
	}
	
	

}