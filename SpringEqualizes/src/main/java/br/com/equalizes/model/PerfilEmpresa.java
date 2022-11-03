package br.com.equalizes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "perfil")
@Table(name = "perfil", uniqueConstraints = { @UniqueConstraint(name = "perfil_empresa", columnNames = "id_empresa"),
		@UniqueConstraint(name = "perfil_projeto", columnNames = "id_projetos"), })
public class PerfilEmpresa {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "perfil_id", nullable = false, updatable = false)
	private long perfilId;
	@Column(name = "nome_perfil", nullable = false, updatable = true)
	@NotBlank
	private String nome;
	@Column(name = "senha_perfil", nullable = false, updatable = true)
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
	private String senha;
	@Column(name = "perfil_ativo", updatable = true, nullable = false)
	@NotNull
	private boolean perfilAtivo;
	@Column(name = "data_criado", updatable = false, nullable = false)
	@NotNull
	private LocalDateTime dataCriado;
	@Column(name = "data_modificado", updatable = true, nullable = true)
	private LocalDateTime dataModificado;
	@Column(name = "id_empresa", nullable = false, updatable = false)
	@NotNull
	private long idEmpresa;
	@Column(name = "id_projeto", nullable = true, updatable = true)
	private long idProjeto;
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "PerfilEmpresa [" + (dataCriado != null ? "dataCriado=" + dataCriado + ", " : "")
				+ (dataModificado != null ? "dataModificado=" + dataModificado + ", " : "") + "idEmpresa=" + idEmpresa
				+ ", idProjeto=" + idProjeto + ", " + (nome != null ? "nome=" + nome + ", " : "") + "perfilAtivo="
				+ perfilAtivo + ", perfilId=" + perfilId + ", " + (senha != null ? "senha=" + senha : "") + "]";
	}

	/**
	 * @param perfilId
	 * @param nome
	 * @param senha
	 * @param perfilAtivo
	 * @param dataCriado
	 * @param dataModificado
	 * @param idEmpresa
	 * @param idProjeto
	 */
	public PerfilEmpresa(final long perfilId, final String nome, final String senha, final boolean perfilAtivo,
			final LocalDateTime dataCriado, final LocalDateTime dataModificado, final long idEmpresa,
			final long idProjeto) {
		this.perfilId = perfilId;
		this.nome = nome;
		this.senha = senha;
		this.perfilAtivo = perfilAtivo;
		this.dataCriado = dataCriado;
		this.dataModificado = dataModificado;
		this.idEmpresa = idEmpresa;
		this.idProjeto = idProjeto;
	}

	/**
	 * @param nome
	 * @param senha
	 * @param perfilAtivo
	 * @param dataCriado
	 * @param dataModificado
	 * @param idEmpresa
	 * @param idProjeto
	 */
	public PerfilEmpresa(final String nome, final String senha, final boolean perfilAtivo,
			final LocalDateTime dataCriado, final LocalDateTime dataModificado, final long idEmpresa,
			final long idProjeto) {
		this.nome = nome;
		this.senha = senha;
		this.perfilAtivo = perfilAtivo;
		this.dataCriado = dataCriado;
		this.dataModificado = dataModificado;
		this.idEmpresa = idEmpresa;
		this.idProjeto = idProjeto;
	}

	/**
	 *
	 */
	public PerfilEmpresa() {
	}

	/**
	 * @return the perfilId
	 */
	public long getPerfilId() {
		return perfilId;
	}

	/**
	 * @param perfilId the perfilId to set
	 */
	public void setPerfilId(final long perfilId) {
		this.perfilId = perfilId;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(final String senha) {
		this.senha = senha;
	}

	/**
	 * @return the perfilAtivo
	 */
	public boolean isPerfilAtivo() {
		return perfilAtivo;
	}

	/**
	 * @param perfilAtivo the perfilAtivo to set
	 */
	public void setPerfilAtivo(final boolean perfilAtivo) {
		this.perfilAtivo = perfilAtivo;
	}

	/**
	 * @return the dataCriado
	 */
	public LocalDateTime getDataCriado() {
		return dataCriado;
	}

	/**
	 * @param dataCriado the dataCriado to set
	 */
	public void setDataCriado(final LocalDateTime dataCriado) {
		this.dataCriado = dataCriado;
	}

	/**
	 * @return the dataModificado
	 */
	public LocalDateTime getDataModificado() {
		return dataModificado;
	}

	/**
	 * @param dataModificado the dataModificado to set
	 */
	public void setDataModificado(final LocalDateTime dataModificado) {
		this.dataModificado = dataModificado;
	}

	/**
	 * @return the idEmpresa
	 */
	public long getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa the idEmpresa to set
	 */
	public void setIdEmpresa(final long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the idProjeto
	 */
	public long getIdProjeto() {
		return idProjeto;
	}

	/**
	 * @param idProjeto the idProjeto to set
	 */
	public void setIdProjeto(final long idProjeto) {
		this.idProjeto = idProjeto;
	}

}
