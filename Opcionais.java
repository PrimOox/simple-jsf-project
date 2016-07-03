package br.com.trabalho.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Opcionais implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OPCIONAIS_ID")
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany
	private BigDecimal valorAdicional;

	@Override
	public Long getId() {
		return this.id;
	}
}
