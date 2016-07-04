package br.com.trabalho.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Montadora implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MONTADORA_ID")
	private Long id;

	@Column(name = "MONTADORA_NOME")
	private String nome;

	@OneToMany(mappedBy = "montadora", targetEntity = Modelo.class, cascade = CascadeType.ALL)
	private List<Modelo> modelos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

}
