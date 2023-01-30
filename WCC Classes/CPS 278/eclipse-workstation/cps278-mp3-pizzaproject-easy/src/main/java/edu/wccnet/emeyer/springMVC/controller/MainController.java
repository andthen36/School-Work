package edu.wccnet.emeyer.springMVC.controller;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.emeyer.springMVC.domain.Order;
import edu.wccnet.emeyer.springMVC.domain.Pizza;
import edu.wccnet.emeyer.springMVC.domain.pizzaRegService;

@Controller
public class MainController {
	
	@Autowired
	private pizzaRegService regService;
	
	@RequestMapping("/")
	public String showForm(Model model) {
		model.addAttribute("order", new Order());
		return "info-form";
	}
		
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("order")Order order,
			BindingResult result) {
		if(result.hasErrors()) {
			return "info-form";
		} else {
			return "confirmation";
		}
		
	}
	@ModelAttribute
	public void populateFormWithData(Model model) {
		model.addAttribute("sizeList", regService.populateSize());
		model.addAttribute("stateList", regService.populateState());
		model.addAttribute("toppingList", regService.populateTopping());
	}
	

}