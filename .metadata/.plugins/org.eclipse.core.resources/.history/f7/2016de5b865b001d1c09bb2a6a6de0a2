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
@Table(name = "perfil", uniqueConstraints = { @UniqueConstraint(name = "perfil_escola", columnNames = "id_escola"),
		@UniqueConstraint(name = "perfil_interese", columnNames = "id_intereses"), })
public class PerfilEscola {
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
	@Column(name = "id_escola", nullable = false, updatable = false)
	@NotNull
	private long idEscola;
	@Column(name = "id_interese", nullable = true, updatable = true)
	private long idInterese;
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "PerfilEscola [" + (dataCriado != null ? "dataCriado=" + dataCriado + ", " : "")
				+ (dataModificado != null ? "dataModificado=" + dataModificado + ", " : "") + "idEscola=" + idEscola
				+ ", idInterese=" + idInterese + ", " + (nome != null ? "nome=" + nome + ", " : "") + "perfilAtivo="
				+ perfilAtivo + ", perfilId=" + perfilId + ", " + (senha != null ? "senha=" + senha : "") + "]";
	}

	/**
	 * @param perfilId
	 * @param nome
	 * @param senha
	 * @param perfilAtivo
	 * @param dataCriado
	 * @param dataModificado
	 * @param idEscola
	 * @param idInterese
	 */
	public PerfilEscola(final long perfilId, final String nome, final String senha, final boolean perfilAtivo,
			final LocalDateTime dataCriado, final LocalDateTime dataModificado, final long idEscola,
			final long idInterese) {
		this.perfilId = perfilId;
		this.nome = nome;
		this.senha = senha;
		this.perfilAtivo = perfilAtivo;
		this.dataCriado = dataCriado;
		this.dataModificado = dataModificado;
		this.idEscola = idEscola;
		this.idInterese = idInterese;
	}

	/**
	 * @param nome
	 * @param senha
	 * @param perfilAtivo
	 * @param dataCriado
	 * @param dataModificado
	 * @param idEscola
	 * @param idInterese
	 */
	public PerfilEscola(final String nome, final String senha, final boolean perfilAtivo,
			final LocalDateTime dataCriado, final LocalDateTime dataModificado, final long idEscola,
			final long idInterese) {
		this.nome = nome;
		this.senha = senha;
		this.perfilAtivo = perfilAtivo;
		this.dataCriado = dataCriado;
		this.dataModificado = dataModificado;
		this.idEscola = idEscola;
		this.idInterese = idInterese;
	}

	/**
	 *
	 */
	public PerfilEscola() {
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
	 * @return the idEscola
	 */
	public long getIdEscola() {
		return idEscola;
	}

	/**
	 * @param idEscola the idEscola to set
	 */
	public void setIdEscola(final long idEscola) {
		this.idEscola = idEscola;
	}

	/**
	 * @return the idInterese
	 */
	public long getIdInterese() {
		return idInterese;
	}

	/**
	 * @param idInterese the idInterese to set
	 */
	public void setIdInterese(final long idInterese) {
		this.idInterese = idInterese;
	}

}
