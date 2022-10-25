package br.com.equalizes.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name = "contato")
public class Contato {
	
	// ATRIBUTOS
	
	@Id
	// IDENTITY = CHAVE PRIMÁRIA E AUTOINCREMENT
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "assunto", length = 60, nullable = false)
	private String assunto;
	
	@Column(name = "mensagem", nullable = false)
	private String mensagem;
	
	@Column(name = "status", length = 20, nullable = true)
	private String status;
	
	@Column(nullable = false, name = "dataContato")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataContato;	
	
	@Column(nullable = true, name = "dataResposta")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataResposta;	
	
	
	public Contato() {}


	public Contato(Long id, String nome, String email, String assunto, String mensagem, String status,
			LocalDate dataContato, LocalDate dataResposta) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.status = status;
		this.dataContato = dataContato;
		this.dataResposta = dataResposta;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAssunto() {
		return assunto;
	}


	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getDataContato() {
		return dataContato;
	}


	public void setDataContato(LocalDate dataContato) {
		this.dataContato = dataContato;
	}


	public LocalDate getDataResposta() {
		return dataResposta;
	}


	public void setDataResposta(LocalDate dataResposta) {
		this.dataResposta = dataResposta;
	}


	
	

}
