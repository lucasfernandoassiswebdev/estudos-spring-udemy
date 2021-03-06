package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null, "Lucas Fernando", "lucas@gmail.com");
		Pessoa p2 = new Pessoa(null, "Thales Henrique", "thales@gmail.com");
		Pessoa p3 = new Pessoa(null, "Bruno Assis", "bruno@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);		
		em.getTransaction().commit();

		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p.toString());

		em.getTransaction().begin();
		Pessoa pes = em.find(Pessoa.class, 2);
		em.remove(pes);
		em.getTransaction().commit();	
		
		em.close();
		emf.close();
		
		System.out.println("Pronto!");
	}
}
