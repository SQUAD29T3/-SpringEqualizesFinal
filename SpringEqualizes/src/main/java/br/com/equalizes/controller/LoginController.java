package br.com.equalizes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Escola;
import br.com.equalizes.repository.EscolaRepository;

@Controller
public class LoginController {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	
	@GetMapping("/login")
	// PÁGINA LOGIN
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("site/login");
		return mv;
	}
	
	@PostMapping("/logar")
	// RECEBE MODEL E OBJETO COM O EMAIL E SENHA
	public String logar(Model model, Escola userParams, HttpSession session) {
		

		// INSTÂNCIA DE USUÁRIO/PERFIL ESCOLA - RETORNA O OBJETO
		Escola escola = this.escolaRepository.Login(userParams.getEmail(), userParams.getSenha());
		
		if(escola != null) {
			session.setAttribute("usuarioLogado", escola);
			return "redirect:/perfilEscola";
			
		}
		
		model.addAttribute("erro", "Email e/ou senha inválidos!");
		return "redirect:/login";
	}
	
	
}
