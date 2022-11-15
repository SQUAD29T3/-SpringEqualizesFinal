package br.com.equalizes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.model.Escola;
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

	// VERIFICA SE HÁ ALGUM CADASTRO PARA O CNPJ INFORMADO, CASO NULL, CADASTRA.
	@PostMapping("/cadastroEmpresa")
	public ModelAndView cadastroEmpresa(Empresa empresa, Model model) throws IOException {

		ModelAndView mv = new ModelAndView("redirect:/cadastroRealizadoEmpresa");

		try {

			if (empresaRepository.findByCnpj(empresa.getCnpj()) != null) {
				ModelAndView modelAndView = new ModelAndView("site/parceiros-empresas");

				model.addAttribute("msg", "Já existe um cadastro para o CNPJ informado: " + empresa.getCnpj() + ".");
				return modelAndView;
			}
			;

		} finally {

		}

		empresaRepository.save(empresa);
		return mv;
	}

	// VIEW DE CONFIRMAÇÃO DE CADASTRO
	@GetMapping("/cadastroRealizadoEmpresa")
	// PÁGINA CADASTRO DE ESCOLAS
	public ModelAndView cadastroRealizado() {
		ModelAndView mv = new ModelAndView("success/success-cad-empresa");
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

	// EXIBE TODOS OS CADASTROS DEFERIDOS PARA O ADM
	@GetMapping("/listarEmpresasAprovadas")
	public ModelAndView listarEscolasAceitas(String status) {
		ModelAndView mv = new ModelAndView("admin/parceiros-empresas/listar");

		List<Empresa> empresas = empresaRepository.findByStatus("deferido");
		mv.addObject("empresas", empresas);

		return mv;
	}

	// == // ATUALIZA A SOLICITAÇÃO DE CADASTRO - EMPRESA
	// APENAS LISTA OS DADOS DO SOLICITANTE E MOSTRA OS CAMPOS P/ ATUALIZAR O
	// REQUERIMENTO
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

	// == EXCLUI PERFIL - NÃO IMPLEMENTADO
	@PostMapping("/desativarPerfilEmpresa")
	public ModelAndView desativarPerfilEmpresa(Empresa empresa) {
		ModelAndView mv = new ModelAndView("redirect:/login");
		empresaRepository.delete(empresa);
		return mv;
	}

}
