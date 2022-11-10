package br.com.equalizes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasPerfilEmpresa {

	@GetMapping("/perfilEmpresa")
	// PÁGINA INICIAL
	public String inicio() {
		return "perfil-empresa/perfil";
	}

	@GetMapping("/pedidos")
	// PÁGINA PEDIDOS
	public String pedidos() {
		return "perfil-empresa/pedidos";
	}

	@GetMapping("/informacoesCadastrais")
	// PÁGINA INFO. CADASTRAIS
	public String infoCadEmpresa() {
		return "perfil-empresa/info-cadastrais";
	}

	@GetMapping("/configuracoesEmpresa")
	// PÁGINA CONFIGURAÇÕES
	public String configuracoes() {
		return "perfil-empresa/configuracoes";
	}

}
