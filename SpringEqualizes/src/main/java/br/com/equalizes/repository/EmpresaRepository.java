package br.com.equalizes.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equalizes.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {


}