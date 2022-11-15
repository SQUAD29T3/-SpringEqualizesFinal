package br.com.equalizes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
	
//	@Autowired
//	private EscolaRepository escolaRepository;
	
	
	@GetMapping("/admin")
	// INICIALIZA A APLICAÇÃO
	public String admin() {
		return "admin/admin";
	}
	
	
	/*
	// REVER ESTE CÓDIGO SE SERÁ UTILIZADO OU NÃO
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O  CADASTRO
	@GetMapping("/{id}/gerarLoginEscola")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("admin/parceiros-escolas/editar");

		Escola escola = escolaRepository.getOne(id);
		mv.addObject("escola", escola);
		

		return mv;
	}

	// ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	@PostMapping("/{id}/gerarLoginEscola")
	public ModelAndView editar(Escola escola) {
		ModelAndView mv = new ModelAndView("redirect:/listarEscolasAprovadas");
		escolaRepository.save(escola);
		

		return mv;
	}

	*/

}
