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
	// PÁGINA CADASTRO DE EMPRESAS
	@GetMapping("/cadastroEmpresa")
	public ModelAndView cadastroEmpresa() {
		return new ModelAndView("site/parceiros-empresas").addObject("cadastroEmpresa", new Empresa());
	}

	// VIEW DE CONFIRMAÇÃO DE CADASTRO
	@GetMapping("/cadastroRealizadoEmpresa")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroRealizado() {
		return new ModelAndView("success/success-cad-empresa");
	}

	// valida o objeto populado na pagina de cadastro
	// salva no banco
	@PostMapping("/cadastroEmpresa")
	public ModelAndView cadastroEmpresa(@Valid final Empresa empresa) throws IOException {
		empresaRepository.save(empresa);
		return new ModelAndView("redirect:/cadastroRealizadoEmpresa");
	}

	// EXIBE TODOS OS CADASTROS PARA O ADM
	// TODO verificacao de seguranca para usuario ADMIN
	// /admin filterchain
	@GetMapping("/listarEmpresas")
	public ModelAndView listarEmpresas() {
		return new ModelAndView("admin/cadastro-empresas/listar").addObject("empresas", empresaRepository.findAll());
	}

	// == // ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O
	// REQUERIMENTO
	@GetMapping("/{cnpj}/responderSolicitacaoCadastroEmpresa")
	public ModelAndView editar(@PathVariable final Long cnpj) {
		return new ModelAndView("admin/cadastro-empresas/editar").addObject("empresas",
				empresaRepository.findByCnpj(cnpj));

	}

	// ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	@PostMapping("/{cnpj}/responderSolicitacaoCadastroEmpresa")
	public ModelAndView editar(@Valid final Empresa empresa) {
		empresaRepository.save(empresa);
		return new ModelAndView("redirect:/listarEmpresas");
	}
}
