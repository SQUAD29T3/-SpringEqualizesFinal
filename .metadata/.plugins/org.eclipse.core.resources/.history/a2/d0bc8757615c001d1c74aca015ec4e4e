package br.com.equalizes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class RotasSite {
	
	
	@GetMapping("/")
	// INICIALIZA A APLICAÇÃO
	public String index() {
		return "index";
	}
	

	
	@GetMapping("/login")
	// PÁGINA LOGIN
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("site/login");
		return modelAndView;
	}


	
	
}
