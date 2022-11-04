package br.com.equalizes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Contato;
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
	
	
	// EXIBE TODOS OS CADASTROS PARA O ADM
	@GetMapping("/listarEmpresas")
	public ModelAndView listarEmpresas() {
		ModelAndView mv = new ModelAndView("admin/cadastro-empresas/listar");

		List<Empresa> empresas = empresaRepository.findAll();
		mv.addObject("empresas", empresas);

		return mv;
	}

	
	// == // ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O REQUERIMENTO
	@GetMapping("/{id}/responderSolicitacaoCadastroEmpresa")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("admin/cadastro-empresas/editar");

		Empresa empresas = empresaRepository.getOne(id);
		mv.addObject("empresas", empresas);

		return mv;
	}

	// ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	@PostMapping("/{id}/responderSolicitacaoCadastroEmpresa")
	public ModelAndView editar(Empresa empresa) {
		ModelAndView mv = new ModelAndView("redirect:/listarEmpresas");
		empresaRepository.save(empresa);

		return mv;
	}

	
	
	

}
