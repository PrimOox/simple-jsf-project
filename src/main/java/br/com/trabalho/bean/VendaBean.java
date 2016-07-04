package br.com.trabalho.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.trabalho.dao.VendaDAO;
import br.com.trabalho.domain.Modelo;
import br.com.trabalho.domain.Venda;
import br.com.trabalho.util.FacesUtils;

@SessionScoped
@ManagedBean(name = "vendaBean")
public class VendaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private VendaDAO vendaDAO;
	
	private List<Venda> vendas;
	
	private Venda venda;
	private Modelo modelo = new Modelo();
	
	@PostConstruct
	public void init() {
		venda = new Venda();
		
		vendas = new ArrayList<Venda>();
		
		vendaDAO = new VendaDAO();
	}
	
	public void novo() {
		venda = new Venda();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("registrar-venda.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			venda.setModelo(modelo);
			
			vendaDAO.salvar(venda);
		} catch (Exception e) {
			FacesUtils.addMsgError("Houve um erro ao registrar a venda! \n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void excluir(Venda venda) {
		try {
			vendaDAO.excluir(venda);
			FacesUtils.addMsgInfo("Venda removida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addMsgError("Houve um erro ao remover: " + e.getMessage());
		}
	}

	public VendaDAO getVendaDAO() {
		return vendaDAO;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public Venda getVenda() {
		return venda;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setVendaDAO(VendaDAO vendaDAO) {
		this.vendaDAO = vendaDAO;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}
