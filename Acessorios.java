package br.com.trabalho.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.trabalho.domain.Modelo;

@Entity
public class Acessorios implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACESSORIOS_ID")
	private Long id;
	
	@ManyToOne
	private Modelo modelo;
	
	@OneToMany
	private BigDecimal valorAdicional;
	
	@OneToMany
	private String nome;

	@Override
	public Long getId() {
		return this.id;
	}
	
	
}
