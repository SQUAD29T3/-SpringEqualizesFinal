package br.com.equalizes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	
	@GetMapping("/admin")
	// INICIALIZA A APLICAÇÃO
	public String admin() {
		return "admin/admin";
	}
	

}
