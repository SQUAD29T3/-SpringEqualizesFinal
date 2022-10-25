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
	
	@GetMapping("/fazerPedido")
	// PÁGINA FAZER PEDIDO
	public String fazerPedidos() {
		return "perfil-escola/fazer-pedido";
	}
	
	@GetMapping("/andamentoPedidos")
	// PÁGINA ANDAMENTO DE PEDIDOS
	public String andamentoPedidos() {
		return "perfil-escola/andamento-pedidos";
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
