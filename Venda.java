package br.com.trabalho.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VENDA_ID")
	private Long id;
	
	@Column 
	private Integer quantidade;
	
	@Column
	private Double desconto;
	
	@Column
	private BigDecimal valorTotal;
	
	@ManyToOne
	private vendasProduto List<Modelo> modelo;


	@Override
	public Long getId() {
		return this.id;
	}

}
