package br.com.equalizes.repository;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.equalizes.model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Long> {

	// LISTA APENAS AS ESCOLAS ACEITAS
	// @Query(value = "select * from escola where status_cadastro = :status",
	// nativeQuery = true)
	// public List<Escola> findByStatus(String status);

	// Devia funcionar tbm
	public List<Escola> findByStatusCadastro(String status);

	// SELECT PARA REALIZAR O LOGIN
	@Query(value = "select * from escola where email = :email", nativeQuery = true)
	public Escola Login(String email);

	public Optional<Escola> findByCnpj(Long cnpj);

}
