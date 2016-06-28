package br.com.trabalho.dao;

import java.io.Serializable;

import br.com.trabalho.domain.Opcionais;

public class OpcionaisDAO extends GenericDAO<Opcionais> implements Serializable {

	private static final long serialVersionUID = 1L;

	public OpcionaisDAO() {
		super(Opcionais.class);
	}

}
