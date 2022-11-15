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

	// == APENAS A ESCOLA TEM ACESSO
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

	
	
	// == CHAMA A VIEW COM  INFORMAÇÕES SOBRE O RASTREAMENTO
	@GetMapping("/{id}/rastreamento")
	public ModelAndView rastreamento(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("perfil-escola/pedido/rastreamento");

		Pedido pedido = pedidoRepository.getOne(id);
		mv.addObject("pedido", pedido);

		return mv;
	}
	
	
	
	// == CHAMA A VIEW COM  INFORMAÇÕES SOBRE O PEDIDO RECEBIDO
	@GetMapping("/{id}/confirmarRecebimento")
	public ModelAndView confirmRecebimento(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("perfil-escola/pedido/confirm-pedido-recebido");

		Pedido pedido = pedidoRepository.getOne(id);
		mv.addObject("pedido", pedido);

		return mv;
	}
	
	
	// ATUALIZA O STATUS DO PEDIDO PARA CONCLUÍDO
	@PostMapping("/{id}/confirmarRecebimento")
	public ModelAndView confirmRecebimento(Pedido pedido) {
		ModelAndView mv = new ModelAndView("redirect:/fazerPedido");
		pedidoRepository.save(pedido);

		return mv;
	}
	
	
	
	// == APENAS A EMPRESA TEM ACESSO
	// PÁGINA ANDAMENTO DE PEDIDOS - LISTA OS PEDIDOS
	
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
		
		// SELECIONA OS PEDIDOS CONCLUÍDOS
		List<Pedido> concluido = pedidoRepository.findConcluido(empresa.getId());
		mv.addObject("concluido", concluido);
		
				
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
	
	
	
	// LISTA TODOS OS PEDIDOS PARA O ADMIN
	
	@GetMapping("/doacoes")
	// PÁGINA PEDIDOS
	public ModelAndView doacoes(Pedido pedido) {
		ModelAndView mv = new ModelAndView("admin/doacoes/listar");

		// SELECIONA OS PEDIDOS CONCLUÍDOS
		List<Pedido> pedidos = pedidoRepository.findAll();		
		mv.addObject("pedidos", pedidos);
					
		return mv;
	}

	
	// == CHAMA A VIEW COM  DETALHES SOBRE O PEDIDO
	@GetMapping("/{id}/detalhesPedido")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("admin/doacoes/detalhes");

		Pedido pedido = pedidoRepository.getOne(id);
		mv.addObject("pedido", pedido);

		return mv;
	}
	
	
	
	
	
	
	
}
