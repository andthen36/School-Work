package edu.wccnet.emeyer.springMVC.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("/")
	public String helloPage(Model model) {
		ArrayList<String> courseList = new ArrayList();
		courseList.add("CPS161");
		courseList.add("CPS261");
		courseList.add("CPS251");
		courseList.add("CPS278");
		model.addAttribute("courseList", courseList);
		return "hello";
	}

}