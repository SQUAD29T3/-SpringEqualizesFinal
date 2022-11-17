package br.com.equalizes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "perfil")
public class Perfil {
  @Id
  @Column(name = "perfil_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "email", length = 50, nullable = false)
  @NotBlank
  @Email
  private String email;
  private boolean enabled;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "perfil_roles", joinColumns = @JoinColumn(name = "perfil_id"), inverseJoinColumns = @JoinColumn(name = "acesso_id"))
  private Set<Acessos> acessos = new HashSet<>();

  @Column(nullable = true)
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
  private String senha;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Acessos> getAcessos() {
    return acessos;
  }

  public void setAcessos(Set<Acessos> acessos) {
    this.acessos = acessos;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

}
