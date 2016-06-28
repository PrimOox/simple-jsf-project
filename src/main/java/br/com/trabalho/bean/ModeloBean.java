package br.com.trabalho.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.trabalho.dao.AcessoriosDAO;
import br.com.trabalho.dao.ModeloDAO;
import br.com.trabalho.dao.OpcionaisDAO;
import br.com.trabalho.domain.Acessorios;
import br.com.trabalho.domain.Modelo;
import br.com.trabalho.domain.Montadora;
import br.com.trabalho.domain.Opcionais;
import br.com.trabalho.util.FacesUtils;

@ViewScoped
@ManagedBean(name = "modeloBean")
public class ModeloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ModeloDAO modeloDAO = new ModeloDAO();
	private OpcionaisDAO opcionaisDAO = new OpcionaisDAO();
	private AcessoriosDAO acessoriosDAO = new AcessoriosDAO();

	private List<Modelo> modelos;
	private List<Opcionais> opcionais;
	private List<Acessorios> acessorios;

	private Modelo modelo;
	private Montadora montadora;
	private Opcionais opcional;
	private Acessorios acessorio;

	@PostConstruct
	public void init() {
		modelo = new Modelo();
		montadora = new Montadora();
		opcional = new Opcionais();
		acessorio = new Acessorios();

		opcionais = new ArrayList<Opcionais>();
		acessorios = new ArrayList<Acessorios>();

		opcionais = opcionaisDAO.findAll();
		acessorios = acessoriosDAO.findAll();
	}
	
	public String addAcessorio() {
		if (acessorio.getNome() == "") {
			return null;
		} else {
			acessorio.setModelo(modelo);;
			modelo = new Modelo();
			return null;
		}
	}
	
	public void salvar() {
		modeloDAO = new ModeloDAO();
		try {
			modelo.getAcessorios().add(acessorio);
			
			modeloDAO.salvar(modelo);
			FacesUtils.addMsgInfo("Produto salvo com sucesso!");
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro-produtos.xhtml");
		} catch (Exception e) {
			FacesUtils.addMsgError("Houve um erro ao salvar! \n" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void editar() {

	}

	public void excluir() {

	}

	public void carregarPesquisa() {
		try {
			modeloDAO = new ModeloDAO();
			modelos = modeloDAO.findAll();
		} catch (Exception e) {
			FacesUtils.addMsgError("Erro ao listar automóveis\n: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
