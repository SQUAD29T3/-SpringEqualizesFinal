package br.com.equalizes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "projeto")
@Table(name = "projeto", uniqueConstraints = { @UniqueConstraint(name = "projeto_escola", columnNames = "id_escola"),
		@UniqueConstraint(name = "projeto_empresa", columnNames = "id_empresa"),
		@UniqueConstraint(name = "projeto_interese", columnNames = "id_interese") })
public class Projeto {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "projeto_id", nullable = false, updatable = false)
	private long projetoId;
	@Column(name = "empresa_id", nullable = false, updatable = false)
	private long empresaId;
	@Column(name = "escola_id", nullable = false, updatable = false)
	private long escolaId;
	@Column(name = "interese_id", nullable = false, updatable = false)
	private long intereseId;
	@Column(name = "data_criado", nullable = false, updatable = false)
	private LocalDateTime dataCriado;
	@Column(name = "data_completo", nullable = true, updatable = true)
	private LocalDateTime dataCompleto;

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Projeto [" + (dataCompleto != null ? "dataCompleto=" + dataCompleto + ", " : "")
				+ (dataCriado != null ? "dataCriado=" + dataCriado + ", " : "") + "empresaId=" + empresaId
				+ ", escolaId=" + escolaId + ", intereseId=" + intereseId + ", projetoId=" + projetoId + "]";
	}

	/**
	 * @return the projetoId
	 */
	public long getProjetoId() {
		return projetoId;
	}

	/**
	 * @param projetoId the projetoId to set
	 */
	public void setProjetoId(final long projetoId) {
		this.projetoId = projetoId;
	}

	/**
	 * @return the empresaId
	 */
	public long getEmpresaId() {
		return empresaId;
	}

	/**
	 * @param empresaId the empresaId to set
	 */
	public void setEmpresaId(final long empresaId) {
		this.empresaId = empresaId;
	}

	/**
	 * @return the escolaId
	 */
	public long getEscolaId() {
		return escolaId;
	}

	/**
	 * @param escolaId the escolaId to set
	 */
	public void setEscolaId(final long escolaId) {
		this.escolaId = escolaId;
	}

	/**
	 * @return the intereseId
	 */
	public long getIntereseId() {
		return intereseId;
	}

	/**
	 * @param intereseId the intereseId to set
	 */
	public void setIntereseId(final long intereseId) {
		this.intereseId = intereseId;
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
	 * @return the dataCompleto
	 */
	public LocalDateTime getDataCompleto() {
		return dataCompleto;
	}

	/**
	 * @param dataCompleto the dataCompleto to set
	 */
	public void setDataCompleto(final LocalDateTime dataCompleto) {
		this.dataCompleto = dataCompleto;
	}

	/**
	 * @param empresaId
	 * @param escolaId
	 * @param intereseId
	 * @param dataCriado
	 * @param dataCompleto
	 */
	public Projeto(final long empresaId, final long escolaId, final long intereseId, final LocalDateTime dataCriado,
			final LocalDateTime dataCompleto) {
		this.empresaId = empresaId;
		this.escolaId = escolaId;
		this.intereseId = intereseId;
		this.dataCriado = dataCriado;
		this.dataCompleto = dataCompleto;
	}

	/**
	 * @param projetoId
	 * @param empresaId
	 * @param escolaId
	 * @param intereseId
	 * @param dataCriado
	 * @param dataCompleto
	 */
	public Projeto(final long projetoId, final long empresaId, final long escolaId, final long intereseId,
			final LocalDateTime dataCriado, final LocalDateTime dataCompleto) {
		this.projetoId = projetoId;
		this.empresaId = empresaId;
		this.escolaId = escolaId;
		this.intereseId = intereseId;
		this.dataCriado = dataCriado;
		this.dataCompleto = dataCompleto;
	}

	/**
	 * Para o spring
	 */
	public Projeto() {
	}

}
