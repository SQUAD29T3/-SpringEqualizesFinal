package br.com.equalizes.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Escola;
import br.com.equalizes.repository.EscolaRepository;

@Controller
public class EscolaController {

	private PasswordEncoder encoder;
	private EscolaRepository escolaRepository;

	// === CADASTRO PARCEIROS => ESCOLAS
	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/cadastroEscola")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroEscola() {
		return new ModelAndView("site/parceiros-escolas").addObject("cadastroEscola", new Escola());
	}

	// VIEW DE CONFIRMAÇÃO DE CADASTRO
	@GetMapping("/cadastroRealizadoEscola")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroRealizado() {
		return new ModelAndView("success/success-cad-escola");
	}

	// Valida e salva escola no banco
	// segue pagina de cadastro
	@PostMapping("/cadastroEscola")
	public ModelAndView solicitacaoContato(final @Valid Escola escola) throws IOException {
		// TODO teste
		// senha criptografada
		escola.setSenha(encoder.encode(escola.getSenha()));
		escolaRepository.save(escola);
		return new ModelAndView("redirect:/cadastroRealizadoEscola");
	}

	// EXIBE TODOS OS CADASTROS PARA O ADM
	// TODO seguranca
	@GetMapping("/listarEscolas")
	public ModelAndView listarEscolas() {
		return new ModelAndView("admin/cadastro-escolas/listar").addObject(escolaRepository.findAll());
	}

	// EXIBE TODOS OS CADASTROS DEFERIDOS PARA O ADM
	// TODO seguranca
	// TODO implementar para empresa
	@GetMapping("/listarEscolasAprovadas")
	public ModelAndView listarEscolasAceitas(final String status) {
		return new ModelAndView("admin/parceiros-escolas/listar")
				.addObject(escolaRepository.findByStatusCadastro("deferido"));
	}

	// == // ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O
	// REQUERIMENTO
	@GetMapping("/{cnpj}/responderSolicitacaoCadastroEscola")
	public ModelAndView editar(@PathVariable final Long cnpj) {
		return new ModelAndView("admin/cadastro-escolas/editar").addObject("escolas",
				escolaRepository.findByCnpj(cnpj));
	}

	// ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	@PostMapping("/{cnpj}/responderSolicitacaoCadastroEscola")
	public ModelAndView editar(final @Valid Escola escola) {
		escolaRepository.save(escola);
		return new ModelAndView("redirect:/listarEscolas");
	}

}
