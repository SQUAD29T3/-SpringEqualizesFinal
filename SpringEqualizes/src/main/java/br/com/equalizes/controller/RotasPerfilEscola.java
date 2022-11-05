package br.com.equalizes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasPerfilEscola {

	
	@GetMapping("/perfilEscola")
	// PÁGINA INICIAL
	public String inicio() {
		return "perfil-escola/perfil";
	}
	
	@GetMapping("/infoCadastrais")
	// PÁGINA INFO. CADASTRAIS
	public String infoCadEscola() {
		return "perfil-escola/info-cadastrais";
	}
	
	@GetMapping("/configuracoesEscola")
	// PÁGINA CONFIGURAÇÕES
	public String configuracoes() {
		return "perfil-escola/configuracoes";
	}

	
	
}
