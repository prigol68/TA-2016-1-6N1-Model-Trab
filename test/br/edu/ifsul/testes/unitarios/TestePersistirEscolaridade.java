package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Escolaridade;
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
public class TestePersistirEscolaridade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirEscolaridade() {
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
            Escolaridade e = new Escolaridade();
            e.setEscolaridade("Superior Incompleto");
            e.setInstituicao("IFSUL");
            e.setDescricao("Técnologo em informática");
            
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
