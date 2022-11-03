package br.com.equalizes.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.repository.EmpresaRepository;


@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	// === CADASTRO PARCEIROS => EMPRESA
	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastroEmpresa")
	// PÁGINA CADASTRO DE EMPRESAS
	public ModelAndView cadastroEmpresa() {
		ModelAndView mv = new ModelAndView("site/parceiros-empresas");
		mv.addObject("cadastroEmpresa", new Empresa());
		return mv;
	}
	
	// VIEW DE CONFIRMAÇÃO DE CADASTRO
	@GetMapping("/cadastroRealizadoEmpresa")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroRealizado() {
		ModelAndView mv = new ModelAndView("success/success-cad-empresa");
		return mv;
	}
	
	
	@PostMapping("/cadastroEmpresa")
	public ModelAndView cadastroEmpresa(Empresa empresa) throws IOException {

		ModelAndView mv = new ModelAndView("redirect:/cadastroRealizadoEmpresa");
		empresaRepository.save(empresa);
		return mv;
	}
	


	
	
	

}
