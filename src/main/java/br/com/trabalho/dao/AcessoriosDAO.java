package br.com.trabalho.dao;

import java.io.Serializable;

import br.com.trabalho.domain.Acessorios;

public class AcessoriosDAO extends GenericDAO<Acessorios> implements Serializable {

	private static final long serialVersionUID = 1L;

	public AcessoriosDAO() {
		super(Acessorios.class);
	}

}
