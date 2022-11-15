package br.com.equalizes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.equalizes.model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Long> {

	// LISTA APENAS AS ESCOLAS ACEITAS
	@Query(value = "select * from escola where status_cadastro = :status",
	nativeQuery = true)
	public List<Escola> findByStatus(String status);


	// SELECT PARA REALIZAR O LOGIN
	@Query(value = "select * from escola where email = :email and senha = :senha", nativeQuery = true)
	public Escola Login(String email, String senha);
	
	
	// VERIFICA SE HÁ ALGUM CADASTRO COM O CNPJ INSERIDO
	@Query(value="select * from escola where cnpj = :cnpj", nativeQuery = true)
	public Escola findByCnpj(String cnpj);


}
