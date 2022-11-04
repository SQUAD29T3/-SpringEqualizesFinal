package br.com.equalizes.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "escola")
public class Escola {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cnpj", length = 20, nullable = false, unique = true)
	private String cnpj;
	
	@Column(name = "nomeEscola", nullable = false)
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
	private String cep;
	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;
		
	@Column(name = "cidade", length = 20, nullable = false)
	private String cidade;
	
	@Column(name = "bairro", length = 20, nullable = false)
	private String bairro;
	
	@Column(name = "rua", length = 40, nullable = false)
	private String rua;
	
	@Column(name = "numero", length = 6, nullable = false)
	private String numero;
	
	@Column(name = "complemento", length = 20, nullable = false)
	private String complemento;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(length = 20, nullable = true)
	private String senha;
	
	@Column(name = "telefone", length = 20, nullable = false)
	private String telefone;

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
	
	public Escola() {}

	public Escola(Long id, String cnpj, String nome, int turnos, int qtAlunos, String diretor, String viceDiretor,
			String coordenador, String secretaria, String cep, String uf, String cidade, String bairro, String rua,
			String numero, String complemento, String email, String senha, String telefone, LocalDate dataCadastro,
			LocalDate dataResposta, String statusCadastro, String statusPerfil) {
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
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTurnos() {
		return turnos;
	}

	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}

	public int getQtAlunos() {
		return qtAlunos;
	}

	public void setQtAlunos(int qtAlunos) {
		this.qtAlunos = qtAlunos;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getViceDiretor() {
		return viceDiretor;
	}

	public void setViceDiretor(String viceDiretor) {
		this.viceDiretor = viceDiretor;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public String getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(String secretaria) {
		this.secretaria = secretaria;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDate dataResposta) {
		this.dataResposta = dataResposta;
	}

	public String getStatusCadastro() {
		return statusCadastro;
	}

	public void setStatusCadastro(String statusCadastro) {
		this.statusCadastro = statusCadastro;
	}

	public String getStatusPerfil() {
		return statusPerfil;
	}

	public void setStatusPerfil(String statusPerfil) {
		this.statusPerfil = statusPerfil;
	}

	
	
	
	
	

}
