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

import br.com.equalizes.model.Contato;
import br.com.equalizes.model.Escola;
import br.com.equalizes.model.Pedido;
import br.com.equalizes.repository.PedidoRepository;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/fazerPedido")
	// PÁGINA FAZER PEDIDO - ESCOLAS
	public ModelAndView fazerPedidos() {
		ModelAndView mv = new ModelAndView("perfil-escola/fazer-pedido");
		mv.addObject("pedido", new Pedido());
		return mv;
	}
	
	@PostMapping("/fazerPedido")
	public ModelAndView solicitacaoContato(Pedido pedido, Model model) throws IOException {
		ModelAndView mv = new ModelAndView("redirect:/fazerPedido");
		
		pedidoRepository.save(pedido);
		
		model.addAttribute("msg", "Pedido realizado com sucesso!");
		return mv;
	}
	
	
	// == APENAS A ESCOLA TÊM ACESSO
	// PÁGINA ANDAMENTO DE PEDIDOS - LISTA OS PEDIDOS
	@PostMapping("/andamentoPedidos")
	public ModelAndView listarPedidos(Escola escola) {
		ModelAndView mv = new ModelAndView("perfil-escola/andamento-pedidos");
		
		// SELECIONA OS PEDIDOS EM ABERTO
		List<Pedido> emAberto = pedidoRepository.buscarEmAberto(escola.getId());
		mv.addObject("pedido", emAberto);
		
		// SELECIONA OS PEDIDOS EM ANDAMENTO
		List<Pedido> emAndamento = pedidoRepository.buscarEmAndamento(escola.getId());
		mv.addObject("emAndamento", emAndamento);
		
		// SELECIONA OS PEDIDOS CONCLUÍDOS
		List<Pedido> concluido = pedidoRepository.buscarConcluido(escola.getId());
		mv.addObject("concluido", concluido);

		
		return mv;
	}
	
	
	// == // ATUALIZA A SOLICITAÇÃO DE PEDIDO
	// APENAS LISTA OS DADOS DO PEDIDO E MOSTRA OS CAMPOS P/ ATUALIZAR O REQUERIMENTO
	@GetMapping("/{id}/editarPedido")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("perfil-escola/pedido/editar");

		Pedido pedido = pedidoRepository.getOne(id);
		mv.addObject("pedido", pedido);

		return mv;
	}

	// ATUALIZA A SOLICITAÇÃO DE CONTATO
	@PostMapping("/{id}/editarPedido")
	public ModelAndView editar(Pedido pedido) {
		ModelAndView mv = new ModelAndView("redirect:/fazerPedido");
		pedidoRepository.save(pedido);

		return mv;
	}
	
	
	// == EXCLUI UM PEDIDO
	@GetMapping("/{id}/excluirPedido")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("redirect:/fazerPedido");
		pedidoRepository.deleteById(id);
		return mv;
	}
	
	

}
