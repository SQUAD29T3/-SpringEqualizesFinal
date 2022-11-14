package br.com.equalizes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Escola;
import br.com.equalizes.repository.EscolaRepository;


@Controller
public class RotasPerfilEscola {

	@Autowired
	private EscolaRepository escolaRepository;

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

	// ATUALIZA OS DADOS
	@PostMapping("/infoCadastrais")
	// PÁGINA INFO. CADASTRAIS
	public ModelAndView editar(Escola escola) {
		ModelAndView mv = new ModelAndView("redirect:/infoCadastrais");
		escolaRepository.save(escola);
		return mv;
	}

	@GetMapping("/configuracoesEscola")
	// PÁGINA CONFIGURAÇÕES
	public String configuracoes() {
		return "perfil-escola/configuracoes";
	}

	
	// ATUALIZA O EMAIL E/OU SENHA
	@PostMapping("/configuracoesEscola")
	// PÁGINA CONFIGURAÇÕES
	public ModelAndView configuracoes(Escola escola) {
		ModelAndView mv = new ModelAndView("redirect:/configuracoesEscola");
		escolaRepository.save(escola);
		return mv;
	}
	
	
	
	
	
}
