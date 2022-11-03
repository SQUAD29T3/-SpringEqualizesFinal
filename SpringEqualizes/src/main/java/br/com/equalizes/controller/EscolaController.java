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
import br.com.equalizes.model.Escola;
import br.com.equalizes.repository.EscolaRepository;


@Controller
public class EscolaController {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	// === CADASTRO PARCEIROS => ESCOLAS
	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastroEscola")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroEscola() {
		ModelAndView mv = new ModelAndView("site/parceiros-escolas");
		mv.addObject("cadastroEscola", new Escola());
		return mv;
	}
	
	// VIEW DE CONFIRMAÇÃO DE CADASTRO
	@GetMapping("/cadastroRealizadoEscola")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroRealizado() {
		ModelAndView mv = new ModelAndView("success/success-cad-escola");
		return mv;
	}
	
	@PostMapping("/cadastroEscola")
	public ModelAndView solicitacaoContato(Escola escola) throws IOException {

		ModelAndView mv = new ModelAndView("redirect:/cadastroRealizadoEscola");
		escolaRepository.save(escola);
		return mv;
	}
	
	
	// EXIBE TODOS OS CADASTROS PARA O ADM
	@GetMapping("/listarEscolas")
	public ModelAndView listarEscolas() {
		ModelAndView mv = new ModelAndView("admin/parceiros-escolas/listar");

		List<Escola> escolas = escolaRepository.findAll();
		mv.addObject("escolas", escolas);

		return mv;
	}
	
	
	// == // ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O REQUERIMENTO
	@GetMapping("/{id}/responderSolicitacaoCadastroEscola")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("admin/parceiros-escolas/editar");

		Escola escolas = escolaRepository.getOne(id);
		mv.addObject("escolas", escolas);

		return mv;
	}

	// ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	@PostMapping("/{id}/responderSolicitacaoCadastroEscola")
	public ModelAndView editar(Escola escola) {
		ModelAndView mv = new ModelAndView("redirect:/listarEscolas");
		escolaRepository.save(escola);

		return mv;
	}
	
	

}
