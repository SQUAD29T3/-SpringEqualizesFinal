package br.com.equalizes.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.model.Escola;
import br.com.equalizes.repository.EmpresaRepository;
import br.com.equalizes.repository.EscolaRepository;

@Controller
public class LoginController {

	private EscolaRepository escolaRepository;

	private EmpresaRepository empresaRepository;

	@GetMapping("/login")
	// PÁGINA LOGIN
	public ModelAndView login() {
		return new ModelAndView("site/login");
	}

	// TODO rever isso
	// levar em conta senhas criptografadas
	@PostMapping("/logar")
	// RECEBE MODEL E OBJETO COM O EMAIL E SENHA
	public String logar(final Model model, @Valid final Escola userParams, @Valid final Empresa userEmpresa,
			final HttpSession session) {
		// TODO funcional
		// INSTÂNCIA DE USUÁRIO/PERFIL ESCOLA - RETORNA O OBJETO
		final Escola escola = escolaRepository.Login(userParams.getEmail(), userParams.getSenha());

		// INSTÂNCIA DE USUÁRIO/PERFIL EMPRESA - RETORNA O OBJETO
		final Empresa empresa = empresaRepository.Login(userEmpresa.getEmail(), userEmpresa.getSenha());

		if (escola != null) {
			session.setAttribute("escolaLogada", escola);
			return "redirect:/perfilEscola";

		} else if (empresa != null) {
			session.setAttribute("empresaLogada", empresa);
			return "redirect:/perfilEmpresa";
		}

		model.addAttribute("erro", "Email e/ou senha inválidos!");
		return "redirect:/login";
	}

	// TODO juntar login com cadastro
	// autenticacao

	// LOGOUT - ENCERRA A SESSÃO
	@PostMapping("/logout")
	public String logout(final HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
