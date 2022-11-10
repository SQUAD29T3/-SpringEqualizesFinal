package br.com.equalizes.controller;

import br.com.equalizes.model.Escola;
import br.com.equalizes.repository.EscolaRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

  // Autowired n costuma ser necessario
  // de acordo com a documentacao
  // @Autowired
  private EscolaRepository escolaRepository;

  @GetMapping("/admin")
  // INICIALIZA A APLICAÇÃO
  public String admin() {
    return "admin/admin";
  }

  // TODO olhar oq sera feito
  //  REVER ESTE CÓDIGO SE SERÁ UTILIZADO OU NÃO
  //  APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O
  //  CADASTRO
  @GetMapping("/{id}/gerarLoginEscola")
  public ModelAndView editar(@PathVariable final Long id) {
    return new ModelAndView("admin/parceiros-escolas/editar")
        .addObject("escola", escolaRepository.findById(id));
  }

  // TODO perfil
  //  utilizar para pegar dados da escola
  //  e gerar um user
  //  com role escola
  //  melhor metodo para seguranca
  //  ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
  @PostMapping("/{id}/gerarLoginEscola")
  public ModelAndView editar(@Valid final Escola escola) {
    escolaRepository.save(escola);
    return new ModelAndView("redirect:/listarEscolasAprovadas");
  }

  // TODO gerarloginEmpresa
  // TODO gerarLoginbaseado no cnpj
}
