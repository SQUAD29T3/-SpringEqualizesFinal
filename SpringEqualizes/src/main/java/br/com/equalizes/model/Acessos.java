package br.com.equalizes.model;

importavax.persistence.*;

@Entity
@Table(name = "acesso")
public class Acessos {
  @Id
  @Column(name = "acesso_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column private String nome;

  /* referencia para Dados da escola/empresa */
  @Column
  @OneToOne(optional = true)
  @JoinColumn(name = "perf_escola_id", unique = true, nullable = true,
              updatable = false)
  private long escola_id;

  @Column
  @OneToOne(optional = true)
  @JoinColumn(name = "perf_empresa_id", unique = true, nullable = true,
              updatable = false)
  private long empresa_id;

  public int getId() { return id; }

  public void setId(final int id) { this.id = id; }

  public String getNome() { return nome; }

  public void setNome(final String acesso) { this.nome = acesso; }
}
