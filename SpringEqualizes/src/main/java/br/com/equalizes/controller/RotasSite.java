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
	

	@GetMapping("/cadastroEscola")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroEscola() {
		ModelAndView modelAndView = new ModelAndView("site/parceiros-escolas");
		return modelAndView;
	}
	
	@GetMapping("/cadastroEmpresa")
	// PÁGINA CADASTRO DE EMPRESAS
	public ModelAndView cadastroEmpresa() {
		ModelAndView modelAndView = new ModelAndView("site/parceiros-empresas");
		return modelAndView;
	}
	
	@GetMapping("/contato")
	// PÁGINA CONATO
	public ModelAndView contato() {
		ModelAndView modelAndView = new ModelAndView("site/contato");
		return modelAndView;
	}
	
	@GetMapping("/login")
	// PÁGINA LOGIN
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("site/login");
		return modelAndView;
	}

	
	
	
	
}
