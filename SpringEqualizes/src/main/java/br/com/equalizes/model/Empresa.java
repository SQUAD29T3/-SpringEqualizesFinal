package com.exemplo.teste.empresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "empresa")
@Table(name = "empresa", uniqueConstraints = { @UniqueConstraint(name = "empresa_um_cnpj", columnNames = "cnpj"),
		@UniqueConstraint(name = "empresa_telefone_unico", columnNames = "telefone"),
		@UniqueConstraint(name = "empresa_email_unico", columnNames = "email") })
public class Empresa {

	// @SequenceGenerator(name = "empresa_sequence", sequenceName =
	// "empresa_sequence", allocationSize = 1)

	// talvez gere bugs
	// mais simples
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "empresa_id", nullable = false, updatable = false)
	private long empresaId;
	@Column(name = "cnpj", nullable = false, updatable = false, length = 14)
	private long cnpj;
	@Column(name = "nome_fantasia", nullable = false, updatable = true)
	private String nomeFantasia;
	@Column(name = "razao_social", nullable = false)
	private String razaoSocial;
	@Column(name = "ativ_empresarial")
	private String ativEmpresarial;
	@Column(name = "propietario", updatable = true)
	private String propietario;
	@Column(name = "socios", updatable = true)
	private String socios;
	@Column(name = "administrador", updatable = true)
	private String administrador;
	@Column(name = "uf", nullable = false, updatable = false)
	private String uf;
	@Column(name = "cep", nullable = false, length = 8, updatable = false)
	private long cep;
	@Column(name = "cidade")
	private String cidade;
	@Column(name = "bairro")
	private String bairro;
	@Column(name = "rua")
	private String rua;
	@Column(name = "numero")
	private int numero;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "email", nullable = false, updatable = true)
	private String email;
	@Column(name = "telefone", nullable = false, updatable = true, length = 13)
	private long telefone;

	/**
	 * @param empresa_id
	 * @param cnpj
	 * @param nome_fantasia
	 * @param razao_social
	 * @param ativ_empresarial
	 * @param propietario
	 * @param socios
	 * @param administrador
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
	public Empresa(final long empresa_id, final long cnpj, final String nome_fantasia, final String razao_social,
			final String ativ_empresarial, final String propietario, final String socios, final String administrador,
			final String uf, final long cep, final String cidade, final String bairro, final String rua,
			final int numero, final String complemento, final String email, final long telefone) {
		this.empresaId = empresa_id;
		this.cnpj = cnpj;
		this.nomeFantasia = nome_fantasia;
		this.razaoSocial = razao_social;
		this.ativEmpresarial = ativ_empresarial;
		this.propietario = propietario;
		this.socios = socios;
		this.administrador = administrador;
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
	 * @param cnpj
	 * @param nome_fantasia
	 * @param razao_social
	 * @param ativ_empresarial
	 * @param propietario
	 * @param socios
	 * @param administrador
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
	public Empresa(final long cnpj, final String nome_fantasia, final String razao_social,
			final String ativ_empresarial, final String propietario, final String socios, final String administrador,
			final String uf, final long cep, final String cidade, final String bairro, final String rua,
			final int numero, final String complemento, final String email, final long telefone) {
		this.cnpj = cnpj;
		this.nomeFantasia = nome_fantasia;
		this.razaoSocial = razao_social;
		this.ativEmpresarial = ativ_empresarial;
		this.propietario = propietario;
		this.socios = socios;
		this.administrador = administrador;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Empresa [" + (administrador != null ? "administrador=" + administrador + ", " : "")
				+ (ativEmpresarial != null ? "ativ_empresarial=" + ativEmpresarial + ", " : "")
				+ (bairro != null ? "bairro=" + bairro + ", " : "") + "cep=" + cep + ", "
				+ (cidade != null ? "cidade=" + cidade + ", " : "") + "cnpj=" + cnpj + ", "
				+ (complemento != null ? "complemento=" + complemento + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + "empresa_id=" + empresaId + ", "
				+ (nomeFantasia != null ? "nome_fantasia=" + nomeFantasia + ", " : "") + "numero=" + numero + ", "
				+ (propietario != null ? "propietario=" + propietario + ", " : "")
				+ (razaoSocial != null ? "razao_social=" + razaoSocial + ", " : "")
				+ (rua != null ? "rua=" + rua + ", " : "") + (socios != null ? "socios=" + socios + ", " : "")
				+ "telefone=" + telefone + ", " + (uf != null ? "uf=" + uf : "") + "]";
	}

	/**
	 * @return the empresa_id
	 */
	public long getEmpresa_id() {
		return empresaId;
	}

	/**
	 *
	 */
	public Empresa() {
	}

	/**
	 * @param empresa_id the empresa_id to set
	 */
	public void setEmpresa_id(final long empresa_id) {
		this.empresaId = empresa_id;
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
	 * @return the nome_fantasia
	 */
	public String getNome_fantasia() {
		return nomeFantasia;
	}

	/**
	 * @param nome_fantasia the nome_fantasia to set
	 */
	public void setNome_fantasia(final String nome_fantasia) {
		this.nomeFantasia = nome_fantasia;
	}

	/**
	 * @return the razao_social
	 */
	public String getRazao_social() {
		return razaoSocial;
	}

	/**
	 * @param razao_social the razao_social to set
	 */
	public void setRazao_social(final String razao_social) {
		this.razaoSocial = razao_social;
	}

	/**
	 * @return the ativ_empresarial
	 */
	public String getAtiv_empresarial() {
		return ativEmpresarial;
	}

	/**
	 * @param ativ_empresarial the ativ_empresarial to set
	 */
	public void setAtiv_empresarial(final String ativ_empresarial) {
		this.ativEmpresarial = ativ_empresarial;
	}

	/**
	 * @return the propietario
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(final String propietario) {
		this.propietario = propietario;
	}

	/**
	 * @return the socios
	 */
	public String getSocios() {
		return socios;
	}

	/**
	 * @param socios the socios to set
	 */
	public void setSocios(final String socios) {
		this.socios = socios;
	}

	/**
	 * @return the administrador
	 */
	public String getAdministrador() {
		return administrador;
	}

	/**
	 * @param administrador the administrador to set
	 */
	public void setAdministrador(final String administrador) {
		this.administrador = administrador;
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
	public long getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(final long cep) {
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
