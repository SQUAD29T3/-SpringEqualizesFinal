package br.com.equalizes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.equalizes.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    public Optional<Contato> findByEmail(String email);

    public void deleteByEmail(String email);

}
