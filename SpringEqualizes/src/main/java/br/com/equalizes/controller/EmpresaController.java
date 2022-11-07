package br.com.equalizes.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return new ModelAndView("site/parceiros-empresas").addObject("cadastroEmpresa", new Empresa());
	}

	// VIEW DE CONFIRMAÇÃO DE CADASTRO
	@GetMapping("/cadastroRealizadoEmpresa")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroRealizado() {
		return new ModelAndView("success/success-cad-empresa");
	}

	@PostMapping("/cadastroEmpresa")
	public ModelAndView cadastroEmpresa(@Valid final Empresa empresa) throws IOException {
		empresaRepository.save(empresa);
		return new ModelAndView("redirect:/cadastroRealizadoEmpresa");
	}

	// EXIBE TODOS OS CADASTROS PARA O ADM
	@GetMapping("/listarEmpresas")
	public ModelAndView listarEmpresas() {
		return new ModelAndView("admin/cadastro-empresas/listar").addObject("empresas", empresaRepository.findAll());
	}

	// == // ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O
	// REQUERIMENTO
	@GetMapping("/{id}/responderSolicitacaoCadastroEmpresa")
	public ModelAndView editar(@PathVariable final Long id) {
		return new ModelAndView("admin/cadastro-empresas/editar").addObject("empresas", empresaRepository.findById(id));

	}

	// ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	@PostMapping("/{id}/responderSolicitacaoCadastroEmpresa")
	public ModelAndView editar(@Valid final Empresa empresa) {
		empresaRepository.save(empresa);
		return new ModelAndView("redirect:/listarEmpresas");
	}

}
