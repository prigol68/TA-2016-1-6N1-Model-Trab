package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirCidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCidade() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2016-1-6N1-Trab-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            Cidade c = new Cidade();
            c.setNome("Passo Fundo");
            c.setEstado(em.find(Estado.class, 1));
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
