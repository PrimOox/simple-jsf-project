package br.com.trabalho.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Venda implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VENDA_ID")
	private Long id;

	@Column(name = "VENDA_QTD")
	private Integer quantidade;

	@Column(name = "VENDA_DESC")
	private Double desconto;

	@Column(name = "VALOR_TOTAL")
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name = "MODELO_ID")
	private Modelo modelo;

	public Long getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
}
