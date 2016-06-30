package br.com.trabalho.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Modelo implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODELO_ID")
	private Long id;

	@Override
	public Long getId() {
		return this.id;
	}

	@Column
	private String nome;

	@Column
	private String motorizacao;

	@Column
	private Integer portas;

	@Column
	private String cor;

	@Column
	@Temporal(TemporalType.DATE)
	private Date ano;

	@Column
	private BigDecimal valorModelo;

	@Column
	private BigDecimal valorTotalModelo;

	@OneToMany(mappedBy = "modelo", targetEntity = Opcionais.class, cascade = CascadeType.ALL)
	private List<Opcionais> opcionais = new ArrayList<>();

	@OneToMany(mappedBy = "modelo", targetEntity = Acessorios.class, cascade = CascadeType.ALL)
	private List<Acessorios> acessorios = new ArrayList<>();

}
