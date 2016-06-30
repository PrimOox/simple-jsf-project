package br.com.trabalho.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Opcionais implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPCIONAIS_ID")
	private Long id;

	private String nome;
	
	private BigDecimal valorAdicional;
	
	@ManyToOne
	private Modelo modelo;
	
	@Override
	public Long getId() {
		return this.id;
	}
}
