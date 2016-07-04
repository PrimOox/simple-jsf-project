package br.com.trabalho.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.trabalho.dao.AcessoriosDAO;
import br.com.trabalho.domain.Acessorios;
import br.com.trabalho.domain.Modelo;
import br.com.trabalho.util.FacesUtils;

@SessionScoped
@ManagedBean(name = "acessoriosBean")
public class AcessoriosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private AcessoriosDAO acessoriosDAO;

	private List<Acessorios> acessorios;

	private Acessorios acessorio;
	private Modelo modelo = new Modelo();

	@PostConstruct
	public void init() {
		acessorio = new Acessorios();
		acessorios = new ArrayList<Acessorios>();
		acessoriosDAO = new AcessoriosDAO();
	}

	public void novo() {
		acessorio = new Acessorios();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro-produtos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			modelo.setAcessorios(acessorios);
			acessoriosDAO.salvar(acessorio);
			FacesUtils.addMsgInfo("Acessório salvo com sucesso!");
			novo();
		} catch (Exception e) {
			FacesUtils.addMsgError("Houve um erro ao salvar! \n" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void excluir(Acessorios acessorio) {
		try {
			acessoriosDAO.excluir(acessorio);
			FacesUtils.addMsgInfo("Acessorio excluído com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addMsgError("Houve um erro ao excluir: " + e.getMessage());
		}
	}
	
	public void carregarAcessorios() {
		try {
			acessoriosDAO = new AcessoriosDAO();
			acessorios = acessoriosDAO.findAll();
		} catch (Exception e) {
			FacesUtils.addMsgError("Erro ao listar acessorios\n: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public AcessoriosDAO getAcessoriosDAO() {
		return acessoriosDAO;
	}

	public List<Acessorios> getAcessorios() {
		return acessorios;
	}

	public Acessorios getAcessorio() {
		return acessorio;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setAcessoriosDAO(AcessoriosDAO acessoriosDAO) {
		this.acessoriosDAO = acessoriosDAO;
	}

	public void setAcessorios(List<Acessorios> acessorios) {
		this.acessorios = acessorios;
	}

	public void setAcessorio(Acessorios acessorio) {
		this.acessorio = acessorio;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}
