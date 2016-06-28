package br.com.trabalho.util;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		GerenciadorPersistencia.getEntityManager().close();

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		GerenciadorPersistencia.getEntityManager();

	}

}
