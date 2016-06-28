package br.com.trabalho.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class GerenciadorPersistencia {

	@PersistenceContext
	private static EntityManagerFactory entityManager;

	static {
		entityManager = Persistence.createEntityManagerFactory("jsf-projectPU");
	}

	public static EntityManager getEntityManager() {
		return entityManager.createEntityManager();
	}

}