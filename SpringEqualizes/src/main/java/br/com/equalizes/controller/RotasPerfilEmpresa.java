package br.com.equalizes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.model.Escola;
import br.com.equalizes.repository.EmpresaRepository;

@Controller
public class RotasPerfilEmpresa {

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping("/perfilEmpresa")
	// PÁGINA INICIAL
	public String inicio() {
		return "perfil-empresa/perfil";
	}

	@GetMapping("/informacoesCadastrais")
	// PÁGINA INFO. CADASTRAIS
	public String infoCadEmpresa() {
		return "perfil-empresa/info-cadastrais";
	}

	// ATUALIZA OS DADOS
	@PostMapping("/informacoesCadastrais")
	// PÁGINA INFO. CADASTRAIS
	public ModelAndView editar(Empresa empresa) {
		ModelAndView mv = new ModelAndView("redirect:/informacoesCadastrais");
		empresaRepository.save(empresa);
		return mv;
	}

	@GetMapping("/configuracoesEmpresa")
	// PÁGINA CONFIGURAÇÕES
	public String configuracoes() {
		return "perfil-empresa/configuracoes";
	}

	// ATUALIZA O EMAIL E/OU SENHA
	@PostMapping("/configuracoesEmpresa")
	// PÁGINA CONFIGURAÇÕES
	public ModelAndView configuracoes(Empresa empresa) {
		ModelAndView mv = new ModelAndView("redirect:/configuracoesEmpresa");
		empresaRepository.save(empresa);
		return mv;
	}

}
