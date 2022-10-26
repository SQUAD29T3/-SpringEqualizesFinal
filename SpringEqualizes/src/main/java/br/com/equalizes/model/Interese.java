package br.com.equalizes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "interese")
@Table(name = "interese", uniqueConstraints = @UniqueConstraint(name = "interese_perfil", columnNames = "perfil_id"))
public class Interese {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "interese_id", nullable = false, updatable = false)
	private long intereseId;
	@Column(name = "perfil_id", nullable = false, updatable = false)
	private long perfilId;
	@Column(name = "texto", nullable = false, updatable = true)
	private String texto;
	@Column(name = "imagem", nullable = true, updatable = true)
	private String imagem;
	@Column(name = "data_criado", nullable = false, updatable = false)
	private LocalDateTime dataCriado;
	@Column(name = "data_alterado", nullable = true, updatable = false)
	private LocalDateTime dataModificado;

	/**
	 * @param intereseId
	 * @param perfilId
	 * @param texto
	 * @param imagem
	 * @param dataCriado
	 * @param dataModificado
	 */
	public Interese(final long intereseId, final long perfilId, final String texto, final String imagem,
			final LocalDateTime dataCriado, final LocalDateTime dataModificado) {
		this.intereseId = intereseId;
		this.perfilId = perfilId;
		this.texto = texto;
		this.imagem = imagem;
		this.dataCriado = dataCriado;
		this.dataModificado = dataModificado;
	}

	/**
	 * @param perfilId
	 * @param texto
	 * @param imagem
	 * @param dataCriado
	 * @param dataModificado
	 */
	public Interese(final long perfilId, final String texto, final String imagem, final LocalDateTime dataCriado,
			final LocalDateTime dataModificado) {
		this.perfilId = perfilId;
		this.texto = texto;
		this.imagem = imagem;
		this.dataCriado = dataCriado;
		this.dataModificado = dataModificado;
	}

	/**
	 * @param dataModificado
	 */
	public Interese(final LocalDateTime dataModificado) {
		this.dataModificado = dataModificado;
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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(final String texto) {
		this.texto = texto;
	}

	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}

	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(final String imagem) {
		this.imagem = imagem;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Interese [" + (dataCriado != null ? "dataCriado=" + dataCriado + ", " : "")
				+ (dataModificado != null ? "dataModificado=" + dataModificado + ", " : "")
				+ (imagem != null ? "imagem=" + imagem + ", " : "") + "intereseId=" + intereseId + ", perfilId="
				+ perfilId + ", " + (texto != null ? "texto=" + texto : "") + "]";
	}

}
