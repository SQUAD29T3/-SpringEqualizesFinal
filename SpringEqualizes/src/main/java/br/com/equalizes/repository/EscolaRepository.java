package br.com.equalizes.repository;

import br.com.equalizes.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
}