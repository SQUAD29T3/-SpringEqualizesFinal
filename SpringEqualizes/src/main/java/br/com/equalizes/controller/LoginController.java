package br.com.equalizes.controller;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.model.Escola;
import br.com.equalizes.model.Perfil;
import br.com.equalizes.repository.PerfilRepository;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  private PasswordEncoder encoder;
  private PerfilRepository perfilRepository;

  @GetMapping("/login")
  // PÁGINA LOGIN
  public ModelAndView login() {
    return new ModelAndView("site/login");
  }

  // TODO rever isso
  // levar em conta senhas criptografadas
  @PostMapping("/logar")
  // RECEBE MODEL E OBJETO COM O EMAIL E SENHA
  public String logar(final Model model, @Valid final Perfil user,
                      @Valid final Escola userEscola,
                      @Valid final Empresa userEmpresa,
                      final HttpSession session) {
    // TODO funcional
    // INSTÂNCIA DE USUÁRIO/PERFIL ESCOLA - RETORNA O OBJETO
    final Perfil perfil = perfilRepository.getPerfilByEmail(user.getEmail());
    // INSTÂNCIA DE USUÁRIO/PERFIL EMPRESA - RETORNA O OBJETO

    if (perfil != null && encoder.matches(user.getSenha(), perfil.getSenha())) {
      session.setAttribute("perfil_logado", perfil);
      return "redirect:/perfil";
    } else {
      model.addAttribute("erro", "Email e/ou senha inválidos!");
      return "redirect:/login";
    }
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
