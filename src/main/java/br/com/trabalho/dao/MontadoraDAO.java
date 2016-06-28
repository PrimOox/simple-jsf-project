package br.com.trabalho.dao;

import java.io.Serializable;

import br.com.trabalho.domain.Montadora;

public class MontadoraDAO extends GenericDAO<Montadora> implements Serializable {

	private static final long serialVersionUID = 1L;

	public MontadoraDAO() {
		super(Montadora.class);
	}

}
