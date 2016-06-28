package br.com.trabalho.dao;

import java.io.Serializable;

import br.com.trabalho.domain.Venda;

public class VendaDAO extends GenericDAO<Venda> implements Serializable {

	private static final long serialVersionUID = 1L;

	public VendaDAO() {
		super(Venda.class);
	}

}
