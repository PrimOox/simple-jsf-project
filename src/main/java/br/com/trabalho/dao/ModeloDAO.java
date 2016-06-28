package br.com.trabalho.dao;

import java.io.Serializable;

import br.com.trabalho.domain.Modelo;

public class ModeloDAO extends GenericDAO<Modelo> implements Serializable {

	private static final long serialVersionUID = 1L;

	public ModeloDAO() {
		super(Modelo.class);
	}

}
