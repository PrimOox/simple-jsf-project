package br.com.trabalho.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.trabalho.domain.Acessorios;
import br.com.trabalho.domain.Opcionais;

@Entity
public class Modelo implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODELO_ID")
	private Long id;

	@Column
	private String nome;

	@Column
	private String motorizacao;

	@Column
	private Inr portas;

	@Columntege
	private String cor;

	@Column
	private Date ano;

	@Column
	private BigDecimal valorModelo;

	@Column
	private BigDecimal valorTotalModelo;

	@OneToMany(mappedBy = "modelo", targetEntity = Opcionais.class, cascade = CascadeType.ALL)
	private List<Opcionais> opcionais = new ArrayList<>();

	@OneToMany(mappedBy = "modelo", targetEntity = Acessorios.class, cascade = CascadeType.ALL)
	private List<Acessorios> acessorios = new ArrayList<>();

	@Override
	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMotorizacao() {
		return motorizacao;
	}

	public void setMotorizacao(String motorizacao) {
		this.motorizacao = motorizacao;
	}

	public Integer getPortas() {
		return portas;
	}

	public void setPortas(Integer portas) {
		this.portas = portas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public BigDecimal getValorModelo() {
		return valorModelo;
	}

	public void setValorModelo(BigDecimal valorModelo) {
		this.valorModelo = valorModelo;
	}

	public BigDecimal getValorTotalModelo() {
		return valorTotalModelo;
	}

	public void setValorTotalModelo(BigDecimal valorTotalModelo) {
		this.valorTotalModelo = valorTotalModelo;
	}

	public List<Opcionais> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcionais> opcionais) {
		this.opcionais = opcionais;
	}

	public List<Acessorios> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorios> acessorios) {
		this.acessorios = acessorios;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
