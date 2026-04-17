/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.upf.ccc.appcontroleavaliacoes.dao;
import br.upf.ccc.classes.Avaliacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 210305@upf.br
 */
public class AvaliacaoDao implements OperacoesBanco{
	// singleton para conexao com BD = factory
	private static EntityManagerFactory factory;
	private EntityManager getEntityManager() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("AppControleAvaliacoesPU");
		return factory.createEntityManager();

	}

	@Override	
	public List<Avaliacao> getLista() {
		EntityManager em = getEntityManager();
		List<Avaliacao> ret = em.createQuery("select o from Avaliacao o").getResultList();
		em.close();
		return ret;
	}
	
	@Override	
	public void persistir(Avaliacao a) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override	
	public void excluir(Avaliacao a) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(a));
		em.getTransaction().commit();
		em.close();
	}
}