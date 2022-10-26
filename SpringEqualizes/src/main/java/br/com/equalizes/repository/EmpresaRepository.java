package br.com.equalizes.repository;

import java.util.Optional;

import br.com.equalizes.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Query("SELECT e  FROM Empresa e WHERE e.cnpj = ?1")
	Optional<Empresa> findEmpresabyCnpj(Long cnpj);
}
