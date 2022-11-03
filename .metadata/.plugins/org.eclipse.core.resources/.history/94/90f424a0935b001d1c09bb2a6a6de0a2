package br.com.equalizes.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "contato")
@Table(name = "contato")
public class Contato {


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "contato_id", updatable = false, nullable = false)
	private long contatoId;

	@Column(name = "nome", updatable = false, nullable = false)
	@NotBlank
	private String nome;

	@Column(name = "email", updatable = false, nullable = false)
	@Email
	private String email;
	@Column(name = "assunto_texto", updatable = false, nullable = false)
		private String assuntoTexto;
	@Column(name = "processado", updatable = true, nullable = false)
	private boolean processado;

	/**
	 * @return the contatoId
	 */
	public long getContatoId() {
		return contatoId;
	}

	/**
	 * @param contatoId the contatoId to set
	 */
	public void setContatoId(final long contatoId) {
		this.contatoId = contatoId;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * @return the assuntoTexto
	 */
	public String getAssuntoTexto() {
		return assuntoTexto;
	}

	/**
	 * @param assuntoTexto the assuntoTexto to set
	 */
	public void setAssuntoTexto(final String assuntoTexto) {
		this.assuntoTexto = assuntoTexto;
	}

	/**
	 * @return the processado
	 */
	public boolean isProcessado() {
		return processado;
	}

	/**
	 * @param processado the processado to set
	 */
	public void setProcessado(final boolean processado) {
		this.processado = processado;
	}

	/**
	 * @param contatoId
	 * @param nome
	 * @param email
	 * @param assuntoTexto
	 * @param processado
	 */
	public Contato(final long contatoId, final String nome, final String email, final String assuntoTexto,
			final boolean processado) {
		this.contatoId = contatoId;
		this.nome = nome;
		this.email = email;
		this.assuntoTexto = assuntoTexto;
		this.processado = processado;
	}

	/**
	 * @param nome
	 * @param email
	 * @param assuntoTexto
	 * @param processado
	 */
	public Contato(final String nome, final String email, final String assuntoTexto, final boolean processado) {
		this.nome = nome;
		this.email = email;
		this.assuntoTexto = assuntoTexto;
		this.processado = processado;
	}

	/**
	 *
	 */
	public Contato() {
	}

}
