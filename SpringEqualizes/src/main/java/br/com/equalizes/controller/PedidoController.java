package br.com.equalizes.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
		return new ModelAndView("perfil-escola/fazer-pedido").addObject("pedido", new Pedido());
	}

	// pedido validado de acordo com o modelo
	@PostMapping("/fazerPedido")
	public ModelAndView solicitacaoContato(@Valid final Pedido pedido, final Model model) throws IOException {
		pedidoRepository.save(pedido);
		model.addAttribute("msg", "Pedido realizado com sucesso!");
		return new ModelAndView("redirect:/fazerPedido");
	}

	// == APENAS A ESCOLA TÊM ACESSO
	// PÁGINA ANDAMENTO DE PEDIDOS - LISTA OS PEDIDOS
	@PostMapping("/andamentoPedidos")
	public ModelAndView listarPedidos(Escola escola) {
		ModelAndView mv = new ModelAndView("perfil-escola/andamento-pedidos");
		
		// = SELECTS PARA ESCOLA
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
	// APENAS LISTA OS DADOS DO PEDIDO E MOSTRA OS CAMPOS P/ ATUALIZAR O
	// REQUERIMENTO
	@GetMapping("/{id}/editarPedido")
	public ModelAndView editar(@PathVariable final Long id) {
		return new ModelAndView("perfil-escola/pedido/editar").addObject("pedido", pedidoRepository.findById(id));
	}


	// ATUALIZA A SOLICITAÇÃO DE PEDIDO
	@PostMapping("/{id}/editarPedido")
	public ModelAndView editar(Pedido pedido) {
		pedidoRepository.save(pedido);
		return new ModelAndView("redirect:/fazerPedido");
	}

	// == EXCLUI UM PEDIDO
	@GetMapping("/{id}/excluirPedido")
	public ModelAndView excluir(@PathVariable final Long id) {
		pedidoRepository.deleteById(id);
		return new ModelAndView("redirect:/fazerPedido");
	}
	
	
}
