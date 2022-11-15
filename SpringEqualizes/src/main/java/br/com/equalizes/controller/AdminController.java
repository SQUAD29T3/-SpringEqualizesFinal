package br.com.equalizes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.model.Escola;
import br.com.equalizes.model.Pedido;
import br.com.equalizes.repository.EmpresaRepository;
import br.com.equalizes.repository.EscolaRepository;
import br.com.equalizes.repository.PedidoRepository;


@Controller
public class AdminController {
	
	@Autowired
	private EscolaRepository escolaRepository;
	@Autowired
	
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@GetMapping("/admin")
	// INICIALIZA A APLICAÇÃO
	public ModelAndView admin(Escola escola, Empresa empresa) {
		ModelAndView mv = new ModelAndView("admin/admin");
		
		Escola escolas = escolaRepository.totalPerfisAtivos();
		mv.addObject("escolas", escolas);
		
		Empresa empresas = empresaRepository.PerfisAtivosTotal();
		mv.addObject("empresas", empresas);
		
		
		// QUANTIDADE TOTAL = ABERTO + EM ANDAMENTO + CONCLUÍDOS
		Pedido pedidos = pedidoRepository.totalPedidos();
		mv.addObject("pedidos", pedidos);
		
		// QUANTIDADE TOTAL EM ABERTO
		Pedido emAberto = pedidoRepository.totalEmAberto();
		mv.addObject("emAberto", emAberto);
		
		// QUANTIDADE TOTAL EM ANDAMENTO
		Pedido emAndamento = pedidoRepository.totalEmAndamento();
		mv.addObject("emAndamento", emAndamento);
		
		// QUANTIDADE TOTAL CONCLUÍDOS
		Pedido concluido = pedidoRepository.totalConcluido();
		mv.addObject("concluido", concluido);
		
		
		
		return mv;
	}
	
	
	

	
	

}
