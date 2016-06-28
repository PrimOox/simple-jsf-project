package br.com.trabalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.trabalho.domain.GenericDomain;
import br.com.trabalho.util.GerenciadorPersistencia;

public abstract class GenericDAO<T extends GenericDomain> {

	private final EntityManager entityManager = GerenciadorPersistencia.getEntityManager();

	private final Class<T> objeto;

	private EntityTransaction getTransaction() {
		return entityManager.getTransaction();
	}

	public EntityManager getEntityManager() {

		return entityManager;

	}

	public void close() {
		entityManager.close();
	}

	public GenericDAO(Class<T> objeto) {
		this.objeto = objeto;
	}

	public T getById(Long id) {
		return entityManager.getReference(objeto, id);
	}

	public List<T> findAll() {
		TypedQuery<T> q = entityManager.createQuery(" FROM " + objeto.getSimpleName(), objeto);
		return q.getResultList();
	}

	public void salvar(T objeto) {
		try {
			getTransaction().begin();
			if (objeto.getId() == null) {
				entityManager.persist(objeto);
			} else {
				entityManager.merge(objeto);
			}
			getTransaction().commit();
			getEntityManager().close();
		} catch (Exception e) {
			e.printStackTrace();
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}

	public void update(T objeto) {
		getTransaction().begin();
		entityManager.merge(objeto);
		getTransaction().commit();
		getEntityManager().close();
	}

	public void excluir(T objeto) {
		getTransaction().begin();
		entityManager.remove(entityManager.merge(objeto));
		getTransaction().commit();
		getEntityManager().close();
	}

	public void excluir(Long id) {
		excluir(getById(id));
	}

}
