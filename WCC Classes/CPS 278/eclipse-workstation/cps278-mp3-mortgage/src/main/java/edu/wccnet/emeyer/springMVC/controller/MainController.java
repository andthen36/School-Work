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


import edu.wccnet.emeyer.springMVC.domain.Mortgage;

@Controller
public class MainController {
	
	
	
	@RequestMapping("/")
	public String helloPage(Model model) {
		Mortgage mortgage = new Mortgage();
		 model.addAttribute("mortgage", mortgage);
		return "info-form";
	}
	@RequestMapping("/processForm")
	public String processForm(
		@ModelAttribute("mortgage")Mortgage mortgage) {
		mortgage.calMonthly();
		mortgage.populatePaymentList();
		return "confirmation";
	}
	
	

}