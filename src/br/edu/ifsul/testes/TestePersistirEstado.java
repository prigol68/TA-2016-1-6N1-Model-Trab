
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DanielPrigol
 */
public class TestePersistirEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("TA-2016-1-6N1-Trab-ModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = em.find(Pais.class, 1);
        Estado e = new Estado();
        e.setNome("Rio Grande do Sul");
        e.setUf("RS");
        e.setPais(p);
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
