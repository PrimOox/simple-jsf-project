package br.com.trabalho.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acessorios implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACESSORIO_ID")
	private Long id;
	
	@Column(name = "ACESSORIO_NOME")
	private String nome;
	
	@Column(name = "VALOR_ADICIONAL_AC")
	private BigDecimal valorAdicionalAc;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValorAdicionalAc() {
		return valorAdicionalAc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValorAdicionalAc(BigDecimal valorAdicionalAc) {
		this.valorAdicionalAc = valorAdicionalAc;
	}
	
}
