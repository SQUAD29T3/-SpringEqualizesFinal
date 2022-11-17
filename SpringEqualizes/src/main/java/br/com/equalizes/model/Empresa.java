package br.com.equalizes.model;

import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "empresa")
public class Empresa {
	// REVIEW refatorar empresa e escola
	// separar usuario em outra classe

	@Override
	public String toString() {
		return "Empresa{" + "id=" + id + ", cnpj=" + cnpj + ", nomeFantasia='" + nomeFantasia + '\'' + ", razaoSocial='"
				+ razaoSocial + '\'' + ", ativEmpresarial='" + ativEmpresarial + '\'' + ", propietario='" + propietario
				+ '\'' + ", socios='" + socios + '\'' + ", administrador='" + administrador + '\'' + ", cep=" + cep
				+ ", uf='" + uf + '\'' + ", cidade='" + cidade + '\'' + ", bairro='" + bairro + '\'' + ", rua='" + rua
				+ '\'' + ", numero=" + numero + ", complemento='" + complemento + '\'' + ", email='" + email + '\''
				+ ", senha='" + '\'' + ", telefone=" + telefone + ", dataCadastro=" + dataCadastro + ", dataResposta="
				+ dataResposta + ", statusCadastro='" + statusCadastro + '\'' + ", statusPerfil='" + statusPerfil + '\''
				+ '}';
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "cnpj", nullable = false, length = 20, unique = true)
	@NotBlank
	// Valido: 00.000.000/0000-00 | 00000000000000
	// colocar isso em um erro
	@Pattern(regexp = "\\d{2}.?\\d{3}.?\\d{3}/?\\d{4}-?\\d{2}")
	private long cnpj;

	@Column(name = "nomeFantasia", length = 60)
	private String nomeFantasia;

	@Column(name = "razaoSocial", length = 60, nullable = false)
	@NotBlank
	private String razaoSocial;

	@Column(name = "ativ_empresarial")
	private String ativEmpresarial;

	@Column(name = "propietario")
	private String propietario;

	@Column(name = "socios")
	private String socios;

	@Column(name = "administrador")
	private String administrador;

	@Column(name = "cep", length = 10)
	@NotBlank
	private long cep;

	@Column(name = "uf", length = 2, nullable = false)
	@NotNull
	private String uf;

	@Column(name = "cidade", length = 20, nullable = false)
	@NotBlank
	private String cidade;

	@Column(name = "bairro", length = 20, nullable = false)
	@NotBlank
	private String bairro;

	@Column(name = "rua", length = 40, nullable = false)
	@NotBlank
	private String rua;

	@Column(name = "numero", length = 6, nullable = false)
	@NotBlank
	private long numero;

	@Column(name = "complemento", length = 20, nullable = false)
	@NotBlank
	private String complemento;

	@Column(name = "email", length = 50, nullable = false)
	@NotBlank
	@Email
	private String email;

	@Column(name = "telefone", nullable = false)
	@NotBlank
	private long telefone;

	// FIXME
	// separar usuario da escola

	@Column(nullable = false, name = "dataCadastro")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataCadastro;

	@Column(nullable = true, name = "dataResposta")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataResposta;

	@Column(name = "statusCadastro", length = 15)
	private String statusCadastro;

	@Column(nullable = true, length = 10)
	private String statusPerfil;

	public Empresa() {
	}

	public Empresa(final Long id, final long cnpj, final String nomeFantasia, final String razaoSocial,
			final String ativEmpresarial, final String propietario, final String socios, final String administrador,
			final long cep, final String uf, final String cidade, final String bairro, final String rua,
			final long numero, final String complemento, final String email, final long telefone,
			final LocalDate dataCadastro, final LocalDate dataResposta, final String statusCadastro,
			final String statusPerfil) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.ativEmpresarial = ativEmpresarial;
		this.propietario = propietario;
		this.socios = socios;
		this.administrador = administrador;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.dataResposta = dataResposta;
		this.statusCadastro = statusCadastro;
		this.statusPerfil = statusPerfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(final long cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(final String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(final String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getAtivEmpresarial() {
		return ativEmpresarial;
	}

	public void setAtivEmpresarial(final String ativEmpresarial) {
		this.ativEmpresarial = ativEmpresarial;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(final String propietario) {
		this.propietario = propietario;
	}

	public String getSocios() {
		return socios;
	}

	public void setSocios(final String socios) {
		this.socios = socios;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(final String administrador) {
		this.administrador = administrador;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(final long cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(final String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(final String rua) {
		this.rua = rua;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(final long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(final long telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(final LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(final LocalDate dataResposta) {
		this.dataResposta = dataResposta;
	}

	public String getStatusCadastro() {
		return statusCadastro;
	}

	public void setStatusCadastro(final String statusCadastro) {
		this.statusCadastro = statusCadastro;
	}

	public String getStatusPerfil() {
		return statusPerfil;
	}

	public void setStatusPerfil(final String statusPerfil) {
		this.statusPerfil = statusPerfil;
	}

}
