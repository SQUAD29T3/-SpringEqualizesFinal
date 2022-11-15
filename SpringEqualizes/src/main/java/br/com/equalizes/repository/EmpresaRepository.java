package br.com.equalizes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.model.Escola;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	// LISTA APENAS AS EMPRESAS ACEITAS
	@Query(value = "select * from empresa where status_cadastro = :status",
	nativeQuery = true)
	public List<Empresa> findByStatus(String status);
	
	// SELECT PARA REALIZAR O LOGIN
	@Query(value = "select * from empresa where email = :email and senha = :senha", nativeQuery = true)
	public Empresa Login(String email, String senha);
	
	
	// VERIFICA SE HÁ ALGUM CADASTRO COM O CNPJ INSERIDO
	@Query(value="select * from empresa where cnpj = :cnpj", nativeQuery = true)
	public Empresa findByCnpj(String cnpj);
	
	

}
