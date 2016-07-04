package br.com.trabalho.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.trabalho.dao.OpcionaisDAO;
import br.com.trabalho.domain.Modelo;
import br.com.trabalho.domain.Opcionais;
import br.com.trabalho.util.FacesUtils;

@SessionScoped
@ManagedBean(name = "opcionaisBean")
public class OpcionaisBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private OpcionaisDAO opcionaisDAO = new OpcionaisDAO();

	private Opcionais opcional;
	private Modelo modelo = new Modelo();

	private List<Opcionais> opcionais;

	@PostConstruct
	public void init() {
		opcional = new Opcionais();
		opcionais = new ArrayList<Opcionais>();
		opcionaisDAO = new OpcionaisDAO();
	}

	public void novo() {
		opcional = new Opcionais();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro-produtos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			modelo.setOpcionais(opcionais);
			opcionaisDAO.salvar(opcional);
			FacesUtils.addMsgInfo("Opcional salvo com sucesso!");
			novo();
		} catch (Exception e) {
			FacesUtils.addMsgError("Houve um erro ao salvar! \n" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void excluir(Opcionais opcional) {
		try {
			opcionaisDAO.excluir(opcional);
			FacesUtils.addMsgInfo("Opcional excluído com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addMsgError("Houve um erro ao excluir: " + e.getMessage());
		}
	}

	public void carregarOpcionais() {
		try {
			opcionaisDAO = new OpcionaisDAO();
			opcionais = opcionaisDAO.findAll();
		} catch (Exception e) {
			FacesUtils.addMsgError("Erro ao listar opcionais\n: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public OpcionaisDAO getOpcionaisDAO() {
		return opcionaisDAO;
	}

	public Opcionais getOpcional() {
		return opcional;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public List<Opcionais> getOpcionais() {
		return opcionais;
	}

	public void setOpcionaisDAO(OpcionaisDAO opcionaisDAO) {
		this.opcionaisDAO = opcionaisDAO;
	}

	public void setOpcional(Opcionais opcional) {
		this.opcional = opcional;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setOpcionais(List<Opcionais> opcionais) {
		this.opcionais = opcionais;
	}
}
