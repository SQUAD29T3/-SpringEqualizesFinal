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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(nullable = false)
	private String statusPedido;

	@Column(nullable = true)
	private String empresaProvedora;

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

	public Pedido() {
	}

	public Pedido(Long id, String descricao, String statusPedido, String empresaProvedora, LocalDate dataPedido,
			LocalDate dataAceite, LocalDate dataConclusao, Escola escola) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.statusPedido = statusPedido;
		this.empresaProvedora = empresaProvedora;
		this.dataPedido = dataPedido;
		this.dataAceite = dataAceite;
		this.dataConclusao = dataConclusao;
		this.escola = escola;
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

	public String getEmpresaProvedora() {
		return empresaProvedora;
	}

	public void setEmpresaProvedora(String empresaProvedora) {
		this.empresaProvedora = empresaProvedora;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataAceite, dataConclusao, dataPedido, descricao, empresaProvedora, escola, id,
				statusPedido);
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
		return Objects.equals(dataAceite, other.dataAceite) && Objects.equals(dataConclusao, other.dataConclusao)
				&& Objects.equals(dataPedido, other.dataPedido) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(empresaProvedora, other.empresaProvedora) && Objects.equals(escola, other.escola)
				&& Objects.equals(id, other.id) && Objects.equals(statusPedido, other.statusPedido);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", descricao=" + descricao + ", statusPedido=" + statusPedido
				+ ", empresaProvedora=" + empresaProvedora + ", dataPedido=" + dataPedido + ", dataAceite=" + dataAceite
				+ ", dataConclusao=" + dataConclusao + ", escola=" + escola + "]";
	}

}
