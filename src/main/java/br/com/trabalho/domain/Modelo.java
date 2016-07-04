package br.com.trabalho.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Modelo implements GenericDomain, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODELO_ID")
	private Long id;

	@Column(name = "MODELO_NOME")
	private String nome;

	@Column(name = "MODELO_MOTORIZACAO")
	private String motorizacao;

	@Column(name = "MODELO_PORTAS")
	private Integer portas;

	@Column(name = "MODELO_COR")
	private String cor;

	@Column(name = "MODELO_ANO")
	@Temporal(TemporalType.DATE)
	private Date ano;

	@Column(name = "VALOR_MODELO")
	private BigDecimal valorParcialModelo;

	@Column(name = "VALOR_TOTAL_MODELO")
	private BigDecimal valorTotalModelo;

	@OneToOne
	@JoinColumn(name = "MONTADORA_ID")
	private Montadora montadora;

	@OneToMany(mappedBy = "modelo", targetEntity = Venda.class, cascade = CascadeType.ALL)
	private List<Venda> vendas = new ArrayList<Venda>();

	@ManyToMany
	@JoinTable(name = "MODELO_HAS_OPCIONAIS", joinColumns = { @JoinColumn(name = "MODELO_ID") }, inverseJoinColumns = {	@JoinColumn(name = "OPCIONAIS_ID") })
	private List<Opcionais> opcionais = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "MODELO_HAS_ACESSORIOS", joinColumns = { @JoinColumn(name = "MODELO_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACESSORIO_ID") })
	private List<Acessorios> acessorios = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getMotorizacao() {
		return motorizacao;
	}

	public Integer getPortas() {
		return portas;
	}

	public String getCor() {
		return cor;
	}

	public Date getAno() {
		return ano;
	}

	public BigDecimal getValorParcialModelo() {
		return valorParcialModelo;
	}

	public BigDecimal getValorTotalModelo() {
		return valorTotalModelo;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public List<Opcionais> getOpcionais() {
		return opcionais;
	}

	public List<Acessorios> getAcessorios() {
		return acessorios;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMotorizacao(String motorizacao) {
		this.motorizacao = motorizacao;
	}

	public void setPortas(Integer portas) {
		this.portas = portas;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public void setValorParcialModelo(BigDecimal valorParcialModelo) {
		this.valorParcialModelo = valorParcialModelo;
	}

	public void setValorTotalModelo(BigDecimal valorTotalModelo) {
		this.valorTotalModelo = valorTotalModelo;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public void setOpcionais(List<Opcionais> opcionais) {
		this.opcionais = opcionais;
	}

	public void setAcessorios(List<Acessorios> acessorios) {
		this.acessorios = acessorios;
	}
	
}
