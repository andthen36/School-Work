package edu.wccnet.emeyer.springMVC.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class Hello {
	@Autowired
	@Qualifier("randNumbRequest")
	RandomNumber random1;
	@Autowired
	@Qualifier("randNumbSession")
	RandomNumber random2;
	@RequestMapping("/")
	public void getRandomNumb(HttpServletResponse response) {
		response.getWriter().println();
	}

}