package br.com.equalizes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.equalizes.model.Pedido;

//TODO simplificar?
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	// SELECIONA OS PEDIDOS EM ABERTO
	@Query(value = "select * from pedido where status_pedido = 'em aberto' and escola_id = :escola", nativeQuery = true)
	public List<Pedido> buscarEmAberto(Long escola);

	// SELECIONA OS PEDIDOS EM ANDAMENTO
	@Query(value = "select * from pedido where status_pedido like 'em andamento' and escola_id = :escola", nativeQuery = true)
	public List<Pedido> buscarEmAndamento(Long escola);

	// SELECIONA OS PEDIDOS CONCLUÍDOS
	@Query(value = "select * from pedido where status_pedido like 'concluido' and escola_id = :escola", nativeQuery = true)
	public List<Pedido> buscarConcluido(Long escola);

}
