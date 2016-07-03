package br.com.trabalho.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Montadora implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MONTADORA_ID")
	private Long id;

	@Column
	private String nome;
	
	@ManyToOne
	private List<Modelo> modelos;
		
	@Override
	public Long getId() {
		return this.id;
	}
}
