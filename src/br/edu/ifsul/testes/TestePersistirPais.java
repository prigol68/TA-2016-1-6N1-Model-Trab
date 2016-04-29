
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DanielPrigol
 */
public class TestePersistirPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("TA-2016-1-6N1-Trab-ModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = new Pais();
        p.setNome("Brasil");
        p.setIso("BR");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();        
    }

}
