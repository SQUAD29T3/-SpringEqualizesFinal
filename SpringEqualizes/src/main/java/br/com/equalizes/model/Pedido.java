package br.com.equalizes.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao", nullable = false)
	@NotBlank
	private String descricao;

	@Column(nullable = false)
	private String statusPedido;

	@Column(name = "transportadora")
	private String transportadora;

	@Column(name = "cod_rastreio")
	private String codRastreio;

	@Column(nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataPedido;

	@Column(nullable = true)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataAceite;
	@Column(nullable = true)

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataConclusao;

	// MUITOS PEDIDOS PODEM ESTAR RELACIONADOS COM UMA ESCOLA
	@ManyToOne
	@JoinColumn(name = "escola_id")
	private Escola escola;
	
	// MUITOS PEDIDOS PODEM SER ACEITOS POR MUITAS ESCOLAS
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	public Pedido() {
	}

	public Pedido(Long id, @NotBlank String descricao, String statusPedido, String transportadora, String codRastreio,
			LocalDate dataPedido, LocalDate dataAceite, LocalDate dataConclusao, Escola escola, Empresa empresa) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.statusPedido = statusPedido;
		this.transportadora = transportadora;
		this.codRastreio = codRastreio;
		this.dataPedido = dataPedido;
		this.dataAceite = dataAceite;
		this.dataConclusao = dataConclusao;
		this.escola = escola;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public String getCodRastreio() {
		return codRastreio;
	}

	public void setCodRastreio(String codRastreio) {
		this.codRastreio = codRastreio;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataAceite() {
		return dataAceite;
	}

	public void setDataAceite(LocalDate dataAceite) {
		this.dataAceite = dataAceite;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codRastreio, dataAceite, dataConclusao, dataPedido, descricao, empresa, escola, id,
				statusPedido, transportadora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(codRastreio, other.codRastreio) && Objects.equals(dataAceite, other.dataAceite)
				&& Objects.equals(dataConclusao, other.dataConclusao) && Objects.equals(dataPedido, other.dataPedido)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(empresa, other.empresa)
				&& Objects.equals(escola, other.escola) && Objects.equals(id, other.id)
				&& Objects.equals(statusPedido, other.statusPedido)
				&& Objects.equals(transportadora, other.transportadora);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", descricao=" + descricao + ", statusPedido=" + statusPedido + ", transportadora="
				+ transportadora + ", codRastreio=" + codRastreio + ", dataPedido=" + dataPedido + ", dataAceite="
				+ dataAceite + ", dataConclusao=" + dataConclusao + ", escola=" + escola + ", empresa=" + empresa + "]";
	}

	
	

}
