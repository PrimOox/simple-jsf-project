package br.com.trabalho.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.trabalho.dao.MontadoraDAO;
import br.com.trabalho.domain.Modelo;
import br.com.trabalho.domain.Montadora;
import br.com.trabalho.util.FacesUtils;

@SessionScoped
@ManagedBean(name = "montadoraBean")
public class MontadoraBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private MontadoraDAO montadoraDAO;

	private List<Montadora> montadoras;
	private List<Modelo> modelos;

	private Montadora montadora;

	@PostConstruct
	public void init() {
		montadora = new Montadora();
		montadoras = new ArrayList<Montadora>();
		montadoraDAO = new MontadoraDAO();
	}

	public void addModelos(Modelo modelo) {
		modelos.add(modelo);
		modelo = new Modelo();
	}

	public void novo() {
		montadora = new Montadora();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro-produtos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			montadora.setModelos(modelos);
			montadoraDAO.salvar(montadora);
			FacesUtils.addMsgInfo("Produto salvo com sucesso!");
			novo();
		} catch (Exception e) {
			FacesUtils.addMsgError("Houve um erro ao salvar! \n" + e.getMessage());
			e.printStackTrace();
		}

	}

	public void excluir(Montadora montadora) {
		try {
			montadoraDAO.excluir(montadora);
			FacesUtils.addMsgInfo("Montadora excluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addMsgError("Houve um erro ao excluir: " + e.getMessage());
		}
	}

	public MontadoraDAO getMontadoraDAO() {
		return montadoraDAO;
	}

	public List<Montadora> getMontadoras() {
		return montadoras;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadoraDAO(MontadoraDAO montadoraDAO) {
		this.montadoraDAO = montadoraDAO;
	}

	public void setMontadoras(List<Montadora> montadoras) {
		this.montadoras = montadoras;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

}
