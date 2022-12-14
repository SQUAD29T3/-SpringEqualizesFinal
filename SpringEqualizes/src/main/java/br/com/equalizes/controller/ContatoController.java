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
import br.com.equalizes.repository.ContatoRepository;

@Controller
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	
	// === CADASTRO DE SOLICITAÇÕES DE CONTATO

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/contato")
	public ModelAndView solicitacaoContato() {
		ModelAndView modelAndView = new ModelAndView("site/contato");
		modelAndView.addObject("contatos", new Contato());
		return modelAndView;
	}

	@PostMapping("/contato")
	public ModelAndView solicitacaoContato(Contato contatos) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/solicitacaoContatoSucesso");
		contatoRepository.save(contatos);
		return modelAndView;
	}

	
	// VIEW COM CONFIRMAÇÃO DE ENVIO DA SOLICITAÇÃO
	@GetMapping("/solicitacaoContatoSucesso")
	public String contatoSucesso() {
		return "success/success-contato";
	}
	
	
	
	// EXIBE TODAS AS SOLICITAÇÕES DE CONTATOS PARA O ADM
	@GetMapping("/listarContatos")
	public ModelAndView llistarContatos() {
		ModelAndView mv = new ModelAndView("admin/contato/listar");

		List<Contato> contatos = contatoRepository.findAll();
		mv.addObject("contatos", contatos);

		return mv;
	}
	
	
	// == // ATUALIZA A SOLICITAÇÃO DE CONTATO
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O REQUERIMENTO
	@GetMapping("/{id}/responderSolicitacaoContato")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("admin/contato/editar");

		Contato contatos = contatoRepository.getOne(id);
		mv.addObject("contatos", contatos);

		return mv;
	}

	// ATUALIZA A SOLICITAÇÃO DE CONTATO
	@PostMapping("/{id}/responderSolicitacaoContato")
	public ModelAndView editar(Contato contatos) {
		ModelAndView mv = new ModelAndView("redirect:/listarContatos");
		contatoRepository.save(contatos);

		return mv;
	}
	

	// == EXCLUI UM CADASTRO
	@GetMapping("/{id}/excluirContato")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("redirect:/listarContatos");
		contatoRepository.deleteById(id);
		return mv;
	}
	

	

}
