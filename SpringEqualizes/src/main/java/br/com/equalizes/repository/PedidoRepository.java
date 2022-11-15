package br.com.equalizes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.equalizes.model.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	
	// == SELECTS PARA ESCOLA

	// SELECIONA OS PEDIDOS EM ABERTO
	@Query(value = "select * from pedido where status_pedido = 'em aberto' and escola_id = :escola", nativeQuery = true)
	public List<Pedido> buscarEmAberto(Long escola);

	// SELECIONA OS PEDIDOS EM ANDAMENTO
	@Query(value = "select * from pedido where status_pedido like 'em andamento' and escola_id = :escola", nativeQuery = true)
	public List<Pedido> buscarEmAndamento(Long escola);

	// SELECIONA OS PEDIDOS CONCLUÍDOS
	@Query(value = "select * from pedido where status_pedido like 'concluido' and escola_id = :escola", nativeQuery = true)
	public List<Pedido> buscarConcluido(Long escola);

	
	// == SELECTS PARA EMPRESAS
	// LISTA TODOS OS PEDIDOS NOVOS
	@Query(value = "select * from pedido where status_pedido = 'em aberto'", nativeQuery = true)
	public List<Pedido> buscarNovosPedidos();
	
	@Query(value = "select * from pedido where status_pedido = 'em andamento' and empresa_id = :empresa", nativeQuery = true)
	public List<Pedido> buscarPorEmpresa(Long empresa);
	
	// SELECIONA OS PEDIDOS CONCLUÍDOS
	@Query(value = "select * from pedido where status_pedido like 'concluido' and empresa_id = :empresa", nativeQuery = true)
	public List<Pedido> findConcluido(Long empresa);
	
	
	// CONTA OS PEDIDOS
	@Query(value = "select count(*) id, data_aceite, data_conclusao, data_pedido, descricao,"
			+ " status_pedido, empresa_id, escola_id, cod_rastreio, transportadora from pedido", nativeQuery = true)
	public Pedido totalPedidos();
	
	// CONTA OS PEDIDOS EM ABERTO
	@Query(value = "select count(*) id, data_aceite, data_conclusao, data_pedido, descricao,"
			+ " status_pedido, empresa_id, escola_id, cod_rastreio, transportadora from pedido where status_pedido = 'em aberto'", nativeQuery = true)
	public Pedido totalEmAberto();
	
	// CONTA OS PEDIDOS EM ANDAMENTO
	@Query(value = "select count(*) id, data_aceite, data_conclusao, data_pedido, descricao,"
			+ " status_pedido, empresa_id, escola_id, cod_rastreio, transportadora from pedido where status_pedido = 'em andamento'", nativeQuery = true)
	public Pedido totalEmAndamento();
	
	// CONTA OS PEDIDOS CONCLUÍDOS
	@Query(value = "select count(*) id, data_aceite, data_conclusao, data_pedido, descricao,"
			+ " status_pedido, empresa_id, escola_id, cod_rastreio, transportadora from pedido where status_pedido = 'concluido'", nativeQuery = true)
	public Pedido totalConcluido();
	
	
}
