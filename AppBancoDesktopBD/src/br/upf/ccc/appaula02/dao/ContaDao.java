/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.upf.ccc.appaula02.dao;

import br.upf.ccc.appaula02.model.Conta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 210305@upf.br
 */
public class ContaDao implements OperacoesBanco{
	// singleton para conexao com BD = factory
	private static EntityManagerFactory factory;
	private EntityManager getEntityManager() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("AppBancoDesktopPU");
		return factory.createEntityManager();

	}

	@Override	
	public List<Conta> getLista() {
		EntityManager em = getEntityManager();
		List<Conta> ret = em.createQuery("select o from Conta o").getResultList();
		em.close();
		return ret;
	}
	
	@Override	
	public void persistir(Conta c) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override	
	public void excluir(Conta c) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(c));
		em.getTransaction().commit();
		em.close();
	}
}
