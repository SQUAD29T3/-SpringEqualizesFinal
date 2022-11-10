package br.com.equalizes.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "escola")
public class Escola {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Override
	public String toString() {
		return "Escola{" +
				"id=" + id +
				", cnpj=" + cnpj +
				", nome='" + nome + '\'' +
				", turnos=" + turnos +
				", qtAlunos=" + qtAlunos +
				", diretor='" + diretor + '\'' +
				", viceDiretor='" + viceDiretor + '\'' +
				", coordenador='" + coordenador + '\'' +
				", secretaria='" + secretaria + '\'' +
				", cep=" + cep +
				", uf='" + uf + '\'' +
				", cidade='" + cidade + '\'' +
				", bairro='" + bairro + '\'' +
				", rua='" + rua + '\'' +
				", numero=" + numero +
				", complemento='" + complemento + '\'' +
				", email='" + email + '\'' +
				", senha='" + senha + '\'' +
				", telefone=" + telefone +
				", dataCadastro=" + dataCadastro +
				", dataResposta=" + dataResposta +
				", statusCadastro='" + statusCadastro + '\'' +
				", statusPerfil='" + statusPerfil + '\'' +
				", pedido=" + pedido +
				'}';
	}

	@Column(name = "cnpj", length = 20, nullable = false, unique = true)
	@NotBlank
	// Valido: 00.000.000/0000-00 | 00000000000000
	// colocar isso em um erro
	@Pattern(regexp = "\\d{2}.?\\d{3}.?\\d{3}/?\\d{4}-?\\d{2}")
	private long cnpj;

	@Column(name = "nomeEscola", nullable = false)
	@NotBlank
	private String nome;

	@Column(name = "turnos")
	private int turnos;

	@Column(name = "qt_alunos")
	private int qtAlunos;

	@Column(name = "diretor")
	private String diretor;

	@Column(name = "vice_diretor")
	private String viceDiretor;

	@Column(name = "coordenador")
	private String coordenador;

	@Column(name = "secretaria")
	private String secretaria;

	@Column(name = "cep", length = 10)
	@NotBlank
	private long cep;

	@Column(name = "uf", length = 2, nullable = false)
	@NotBlank
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
	private String complemento;

	@Column(name = "email", length = 50, nullable = false)
	@Email
	private String email;

	@Column(length = 20, nullable = true)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
	private String senha;

	@Column(name = "telefone", length = 20, nullable = false)
	@NotNull
	private long telefone;

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

	// CÓDIGO NOVO
	@OneToMany(mappedBy = "escola")
	private List<Pedido> pedido;

	public Escola() {
	}

	public Escola(final Long id, final long cnpj, final String nome, final int turnos, final int qtAlunos,
			final String diretor, final String viceDiretor, final String coordenador, final String secretaria,
			final long cep, final String uf, final String cidade, final String bairro, final String rua,
			final long numero, final String complemento, final String email, final String senha, final long telefone,
			final LocalDate dataCadastro, final LocalDate dataResposta, final String statusCadastro,
			final String statusPerfil, final List<Pedido> pedido) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.turnos = turnos;
		this.qtAlunos = qtAlunos;
		this.diretor = diretor;
		this.viceDiretor = viceDiretor;
		this.coordenador = coordenador;
		this.secretaria = secretaria;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.dataResposta = dataResposta;
		this.statusCadastro = statusCadastro;
		this.statusPerfil = statusPerfil;
		this.pedido = pedido;
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

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public int getTurnos() {
		return turnos;
	}

	public void setTurnos(final int turnos) {
		this.turnos = turnos;
	}

	public int getQtAlunos() {
		return qtAlunos;
	}

	public void setQtAlunos(final int qtAlunos) {
		this.qtAlunos = qtAlunos;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(final String diretor) {
		this.diretor = diretor;
	}

	public String getViceDiretor() {
		return viceDiretor;
	}

	public void setViceDiretor(final String viceDiretor) {
		this.viceDiretor = viceDiretor;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(final String coordenador) {
		this.coordenador = coordenador;
	}

	public String getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(final String secretaria) {
		this.secretaria = secretaria;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
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

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(final List<Pedido> pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, cnpj, complemento, coordenador, dataCadastro, dataResposta, diretor,
				email, id, nome, numero, pedido, qtAlunos, rua, secretaria, senha, statusCadastro, statusPerfil,
				telefone, turnos, uf, viceDiretor);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Escola other = (Escola) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(coordenador, other.coordenador)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(dataResposta, other.dataResposta)
				&& Objects.equals(diretor, other.diretor) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(numero, other.numero) && Objects.equals(pedido, other.pedido)
				&& qtAlunos == other.qtAlunos && Objects.equals(rua, other.rua)
				&& Objects.equals(secretaria, other.secretaria) && Objects.equals(senha, other.senha)
				&& Objects.equals(statusCadastro, other.statusCadastro)
				&& Objects.equals(statusPerfil, other.statusPerfil) && Objects.equals(telefone, other.telefone)
				&& turnos == other.turnos && Objects.equals(uf, other.uf)
				&& Objects.equals(viceDiretor, other.viceDiretor);
	}

}
