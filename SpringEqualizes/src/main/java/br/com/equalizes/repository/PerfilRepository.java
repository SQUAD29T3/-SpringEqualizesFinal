package br.com.equalizes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.equalizes.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    @Query("SELECT u FROM Perfil u WHERE u.email= :email")
    public Perfil getPerfilByEmail(@Param("email") String email);

    @Query("SELECT p, a FROM Perfil p INNER JOIN p.acessos a")
    public Perfil getPerfilAcessos(@Param("email") String email);
}
