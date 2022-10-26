package br.com.equalizes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "escola")
@Table(name = "escola", uniqueConstraints = { @UniqueConstraint(name = "escola_um_cnpj", columnNames = "cnpj"),
		@UniqueConstraint(name = "escola_telefone_unico", columnNames = "telefone"),
		@UniqueConstraint(name = "escola_email_unico", columnNames = "email") })
public class Escola {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "escola_id", nullable = false, updatable = false)
	private long escolaId;
 	@Column(name = "cnpj", nullable = false, updatable = false, length = 14)
	@Pattern(regexp = "[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}")
	private long cnpj;
	@Column(name = "nome", nullable = false)
	@NotBlank
	private String nome;
	@Column(name = "turnos")
	private String turnos;
	@Column(name = "qt_alunos")
	private long qtAlunos;
	@Column(name = "diretor")
	@NotBlank
	private String diretor;
	@Column(name = "vice_diretor")
	@NotBlank
	private String viceDiretor;
	@Column(name = "coordenador")
	@NotBlank
	private String coordenador;
	@Column(name = "secretaria")
	private String secretaria;
	@Column(name = "uf", length = 2)
	private String uf;
	@Column(name = "cep", length = 8)
	private String cep;
	@Column(name = "cidade")
	@NotBlank
	private String cidade;
	@Column(name = "bairro")
	@NotBlank
	private String bairro;
	@Column(name = "rua")
	@NotBlank
	private String rua;
	@Column(name = "numero")
	@NotNull
	private int numero;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "email", nullable = false, updatable = true)
	@Email
	private String email;
	@Column(name = "telefone", nullable = false, updatable = true, length = 13)
	@NotNull
	private long telefone;

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Escola [" + (bairro != null ? "bairro=" + bairro + ", " : "")
				+ (cep != null ? "cep=" + cep + ", " : "")
				+ (cidade != null ? "cidade=" + cidade + ", " : "") + "cnpj=" + cnpj + ", "
				+ (complemento != null ? "complemento=" + complemento + ", " : "")
				+ (coordenador != null ? "coordenador=" + coordenador + ", " : "")
				+ (diretor != null ? "diretor=" + diretor + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + "escolaId=" + escolaId + ", "
				+ (nome != null ? "nome=" + nome + ", " : "") + "numero=" + numero + ", qtAlunos="
				+ qtAlunos + ", " + (rua != null ? "rua=" + rua + ", " : "")
				+ (secretaria != null ? "secretaria=" + secretaria + ", " : "") + "telefone=" + telefone
				+ ", " + (turnos != null ? "turnos=" + turnos + ", " : "")
				+ (uf != null ? "uf=" + uf + ", " : "")
				+ (viceDiretor != null ? "viceDiretor=" + viceDiretor : "") + "]";
	}

	/**
	 * @param cnpj
	 * @param nome
	 * @param turnos
	 * @param qtAlunos
	 * @param diretor
	 * @param viceDiretor
	 * @param coordenador
	 * @param secretaria
	 * @param uf
	 * @param cep
	 * @param cidade
	 * @param bairro
	 * @param rua
	 * @param numero
	 * @param complemento
	 * @param email
	 * @param telefone
	 */
	public Escola(final long cnpj, final String nome, final String turnos, final long qtAlunos,
			final String diretor, final String viceDiretor, final String coordenador,
			final String secretaria, final String uf, final String cep, final String cidade,
			final String bairro, final String rua, final int numero, final String complemento,
			final String email, final long telefone) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.turnos = turnos;
		this.qtAlunos = qtAlunos;
		this.diretor = diretor;
		this.viceDiretor = viceDiretor;
		this.coordenador = coordenador;
		this.secretaria = secretaria;
		this.uf = uf;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.email = email;
		this.telefone = telefone;
	}

	public Escola() {
	}

	/**
	 * @param escolaId
	 * @param cnpj
	 * @param nome
	 * @param turnos
	 * @param qtAlunos
	 * @param diretor
	 * @param viceDiretor
	 * @param coordenador
	 * @param secretaria
	 * @param uf
	 * @param cep
	 * @param cidade
	 * @param bairro
	 * @param rua
	 * @param numero
	 * @param complemento
	 * @param email
	 * @param telefone
	 */
	public Escola(final long escolaId, final long cnpj, final String nome, final String turnos, final long qtAlunos,
			final String diretor, final String viceDiretor, final String coordenador,
			final String secretaria, final String uf, final String cep, final String cidade,
			final String bairro, final String rua, final int numero, final String complemento,
			final String email, final long telefone) {
		this.escolaId = escolaId;
		this.cnpj = cnpj;
		this.nome = nome;
		this.turnos = turnos;
		this.qtAlunos = qtAlunos;
		this.diretor = diretor;
		this.viceDiretor = viceDiretor;
		this.coordenador = coordenador;
		this.secretaria = secretaria;
		this.uf = uf;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.email = email;
		this.telefone = telefone;
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
	 * @return the cnpj
	 */
	public long getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(final long cnpj) {
		this.cnpj = cnpj;
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
	 * @return the turnos
	 */
	public String getTurnos() {
		return turnos;
	}

	/**
	 * @param turnos the turnos to set
	 */
	public void setTurnos(final String turnos) {
		this.turnos = turnos;
	}

	/**
	 * @return the qtAlunos
	 */
	public long getQtAlunos() {
		return qtAlunos;
	}

	/**
	 * @param qtAlunos the qtAlunos to set
	 */
	public void setQtAlunos(final long qtAlunos) {
		this.qtAlunos = qtAlunos;
	}

	/**
	 * @return the diretor
	 */
	public String getDiretor() {
		return diretor;
	}

	/**
	 * @param diretor the diretor to set
	 */
	public void setDiretor(final String diretor) {
		this.diretor = diretor;
	}

	/**
	 * @return the viceDiretor
	 */
	public String getViceDiretor() {
		return viceDiretor;
	}

	/**
	 * @param viceDiretor the viceDiretor to set
	 */
	public void setViceDiretor(final String viceDiretor) {
		this.viceDiretor = viceDiretor;
	}

	/**
	 * @return the coordenador
	 */
	public String getCoordenador() {
		return coordenador;
	}

	/**
	 * @param coordenador the coordenador to set
	 */
	public void setCoordenador(final String coordenador) {
		this.coordenador = coordenador;
	}

	/**
	 * @return the secretaria
	 */
	public String getSecretaria() {
		return secretaria;
	}

	/**
	 * @param secretaria the secretaria to set
	 */
	public void setSecretaria(final String secretaria) {
		this.secretaria = secretaria;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(final String uf) {
		this.uf = uf;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(final String cep) {
		this.cep = cep;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua the rua to set
	 */
	public void setRua(final String rua) {
		this.rua = rua;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(final int numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(final String complemento) {
		this.complemento = complemento;
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
	 * @return the telefone
	 */
	public long getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(final long telefone) {
		this.telefone = telefone;
	}

}
