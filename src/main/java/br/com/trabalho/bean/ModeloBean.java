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
import br.com.trabalho.dao.ModeloDAO;
import br.com.trabalho.dao.OpcionaisDAO;
import br.com.trabalho.domain.Acessorios;
import br.com.trabalho.domain.Modelo;
import br.com.trabalho.domain.Montadora;
import br.com.trabalho.domain.Opcionais;
import br.com.trabalho.util.FacesUtils;

@SessionScoped
@ManagedBean(name = "modeloBean")
public class ModeloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ModeloDAO modeloDAO = new ModeloDAO();
	private AcessoriosDAO acessoriosDAO = new AcessoriosDAO();
	private OpcionaisDAO opcionaisDAO = new OpcionaisDAO();

	private List<Modelo> modelos;
	private List<Acessorios> acessorios;
	private List<Opcionais> opcionais;

	private Modelo modelo;
	private Montadora montadora;
	private Acessorios acessorio;
	private Opcionais opcional;

	@PostConstruct
	public void init() {
		modelo = new Modelo();

		acessorios = new ArrayList<Acessorios>();
		opcionais = new ArrayList<Opcionais>();

		modeloDAO = new ModeloDAO();

		acessorios = acessoriosDAO.findAll();
		opcionais = opcionaisDAO.findAll();
	}

	public void novo() {
		modelo = new Modelo();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro-produtos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addAcessorio(Acessorios acessorio) {
		acessorios.add(acessorio);
		acessorio = new Acessorios();
	}

	public void addOpcional(Opcionais opcional) {
		opcionais.add(opcional);
		opcional = new Opcionais();
	}

	public void salvar() {
		try {
			modelo.setAcessorios(acessorios);
			modelo.setOpcionais(opcionais);

			if (modelo.getId() == null) {
				modeloDAO.salvar(modelo);
				FacesUtils.addMsgInfo("Produto salvo com sucesso!");
				novo();
			} else {
				modeloDAO.update(modelo);
				FacesUtils.addMsgInfo("Produto atualizado com sucesso!");
				novo();
			}
		} catch (Exception e) {
			FacesUtils.addMsgError("Houve um erro ao salvar! \n" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void editar(Modelo modelo) {
		try {
			this.modelo = modeloDAO.getById(modelo.getId());
			FacesContext.getCurrentInstance().getExternalContext().dispatch("cadastro-produtos.xhtml");
		} catch (IOException e) {
			FacesUtils.addMsgError("Houve um erro ao carregar o cadastro! \n" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void excluir(Modelo modelo) {
		try {
			modeloDAO.excluir(modelo);
			FacesUtils.addMsgInfo("Modelo excluído com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addMsgError("Houve um erro ao excluir: " + e.getMessage());
		}
	}

	public void carregarModelos() {
		try {
			modeloDAO = new ModeloDAO();
			modelos = modeloDAO.findAll();
		} catch (Exception e) {
			FacesUtils.addMsgError("Erro ao listar automóveis\n: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public ModeloDAO getModeloDAO() {
		return modeloDAO;
	}

	public AcessoriosDAO getAcessoriosDAO() {
		return acessoriosDAO;
	}

	public OpcionaisDAO getOpcionaisDAO() {
		return opcionaisDAO;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public List<Acessorios> getAcessorios() {
		return acessorios;
	}

	public List<Opcionais> getOpcionais() {
		return opcionais;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public Acessorios getAcessorio() {
		return acessorio;
	}

	public Opcionais getOpcional() {
		return opcional;
	}

	public void setModeloDAO(ModeloDAO modeloDAO) {
		this.modeloDAO = modeloDAO;
	}

	public void setAcessoriosDAO(AcessoriosDAO acessoriosDAO) {
		this.acessoriosDAO = acessoriosDAO;
	}

	public void setOpcionaisDAO(OpcionaisDAO opcionaisDAO) {
		this.opcionaisDAO = opcionaisDAO;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public void setAcessorios(List<Acessorios> acessorios) {
		this.acessorios = acessorios;
	}

	public void setOpcionais(List<Opcionais> opcionais) {
		this.opcionais = opcionais;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public void setAcessorio(Acessorios acessorio) {
		this.acessorio = acessorio;
	}

	public void setOpcional(Opcionais opcional) {
		this.opcional = opcional;
	}

}
