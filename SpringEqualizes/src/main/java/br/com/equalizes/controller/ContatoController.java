package br.com.equalizes.controller;

import java.io.IOException;

import javax.validation.Valid;

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

	// n e necessario
	// @Autowired
	private ContatoRepository contatoRepository;

	// === CADASTRO DE SOLICITAÇÕES DE CONTATO

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/contato")
	public ModelAndView solicitacaoContato() {
		return new ModelAndView("site/contato").addObject("contatos", new Contato());
	}

	@PostMapping("/contato")
	public ModelAndView solicitacaoContato(@Valid final Contato contato) throws IOException {
		contatoRepository.save(contato);
		return new ModelAndView("redirect:/solicitacaoContatoSucesso");
	}

	// VIEW COM CONFIRMAÇÃO DE ENVIO DA SOLICITAÇÃO
	@GetMapping("/solicitacaoContatoSucesso")
	public String contatoSucesso() {
		return "success/success-contato";
	}

	// EXIBE TODAS AS SOLICITAÇÕES DE CONTATOS PARA O ADM
	// TODO seguranca role ADMIN
	@GetMapping("/listarContatos")
	public ModelAndView listarContatos() {
		return new ModelAndView("admin/contato/listar").addObject("contatos", contatoRepository.findAll());
	}

	// == // ATUALIZA A SOLICITAÇÃO DE CONTATO
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O
	// REQUERIMENTO
	@GetMapping("/{email}/responderSolicitacaoContato")
	public ModelAndView editar(@PathVariable final String email) {
		return new ModelAndView("admin/contato/editar").addObject("contatos", contatoRepository.findByEmail(email));
	}

	// ATUALIZA A SOLICITAÇÃO DE CONTATO
	@PostMapping("/{email}/responderSolicitacaoContato")
	public ModelAndView editar(@Valid final Contato contatos) {
		contatoRepository.save(contatos);
		return new ModelAndView("redirect:/listarContatos");
	}

	// == EXCLUI UM CADASTRO
	@GetMapping("/{email}/excluirContato")
	public ModelAndView excluir(@PathVariable final String email) {
		contatoRepository.deleteByEmail(email);
		return new ModelAndView("redirect:/listarContatos");
	}

}
