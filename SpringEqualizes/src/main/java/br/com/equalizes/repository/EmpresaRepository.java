package br.com.equalizes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.equalizes.model.Empresa;

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
	
	
	// VERIFICA QUANTOS CADASTROS HÁ NO BD
	@Query(value="Select count(*) id, cnpj, razao_social, nome_fantasia, propietario, socios, ativ_empresarial, administrador, rua, complemento, numero, bairro, cidade, uf, cep, data_cadastro,"
			+ " data_resposta, status_cadastro, status_perfil, telefone, email, senha from empresa;", nativeQuery = true)
	public Empresa PerfisAtivosTotal();
	

}
