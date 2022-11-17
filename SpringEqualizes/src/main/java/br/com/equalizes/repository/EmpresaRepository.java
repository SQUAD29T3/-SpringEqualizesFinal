package br.com.equalizes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.equalizes.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	// SELECT PARA REALIZAR O LOGIN
	@Query(value = "select * from empresa where email = :email", nativeQuery = true)
	public Empresa Login(String email);

	public Optional<Empresa> findByCnpj(Long cnpj);
}
