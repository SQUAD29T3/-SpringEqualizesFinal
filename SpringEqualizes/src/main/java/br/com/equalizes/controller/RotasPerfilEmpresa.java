package br.com.equalizes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.model.Escola;
import br.com.equalizes.model.Pedido;
import br.com.equalizes.repository.EmpresaRepository;
import br.com.equalizes.repository.PedidoRepository;

@Controller
public class RotasPerfilEmpresa {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/perfilEmpresa")
	// PÁGINA INICIAL
	public String inicio() {
		return "perfil-empresa/perfil";
	}

	@PostMapping("/pedidos")
	// PÁGINA PEDIDOS
	public ModelAndView pedidos(Empresa empresa) {
		ModelAndView mv = new ModelAndView("perfil-empresa/pedidos");

		// = SELECTS PARA EMPRESA
		// SELECIONA OS PEDIDOS CONCLUÍDOS
		List<Pedido> novos = pedidoRepository.buscarNovosPedidos();		
		mv.addObject("novos", novos);
		
		// SELECIONA OS PEDIDOS EM ANDAMENTO
		List<Pedido> emAndamento = pedidoRepository.buscarPorEmpresa(empresa.getId());
		mv.addObject("emAndamento", emAndamento);
				
		return mv;
	}

	
	
	// ACEITANDO UM PEDIDO
	
	// == CHAMA A VIEW COM OS DADOS DO PEDIDO
	// APENAS LISTA O E MOSTRA OS CAMPOS P/ EDIÇÃO
	@GetMapping("/{id}/aceitarPedido")
	public ModelAndView aceitarPedido(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("perfil-empresa/confirmarDoacao");

		Pedido pedido = pedidoRepository.getOne(id);
		mv.addObject("pedido", pedido);

		return mv;
	}

	
	// ATUALIZA O CADASTRO
	@PostMapping("/{id}/aceitarPedido")
	public ModelAndView aceitarPedido(Pedido pedido) {
		ModelAndView mv = new ModelAndView("redirect:/pedidoAceito");
		pedidoRepository.save(pedido);

		return mv;
	}

	
	@GetMapping("/pedidoAceito")
	// PÁGINA INFO. CADASTRAIS
	public String pedidoAceito() {
		return "perfil-empresa/pedidoAceito";
	}
	
	
	
	// ATUALIZANDO UM PEDIDO - ADICIONANDO A TRANSPORTADORA E CÓDIGO DE RASTREAMENTO
	
	// == CHAMA A VIEW COM OS DADOS DO PEDIDO
	// APENAS LISTA O E MOSTRA OS CAMPOS P/ EDIÇÃO
	@GetMapping("/{id}/atualizarPedido")
	public ModelAndView atualizarPedido(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("perfil-empresa/atualizarPedido");

		Pedido pedido = pedidoRepository.getOne(id);
		mv.addObject("pedido", pedido);

		return mv;
	}
	
	
	// ATUALIZA O PEDIDO COM AS INFORMAÇÕES DE RASTREAMENTO
	@PostMapping("/{id}/atualizarPedido")
	public ModelAndView atualizarPedido(Pedido pedido) {
		ModelAndView mv = new ModelAndView("redirect:/perfilEmpresa");
		pedidoRepository.save(pedido);

		return mv;
	}
	
	
	
	
	
	@GetMapping("/informacoesCadastrais")
	// PÁGINA INFO. CADASTRAIS
	public String infoCadEmpresa() {
		return "perfil-empresa/info-cadastrais";
	}
	
	  	// ATUALIZA OS DADOS
	@PostMapping("/informacoesCadastrais")
	// PÁGINA INFO. CADASTRAIS
	public ModelAndView editar(Empresa empresa) {
		ModelAndView mv = new ModelAndView("redirect:/informacoesCadastrais");
		empresaRepository.save(empresa);
		return mv;
	}
	  	
	
	
	
	

	@GetMapping("/configuracoesEmpresa")
	// PÁGINA CONFIGURAÇÕES
	public String configuracoes() {
		return "perfil-empresa/configuracoes";
	}

}
