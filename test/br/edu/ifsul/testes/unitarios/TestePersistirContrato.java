package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Cargo;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Contrato;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Funcionario;
import java.util.GregorianCalendar;
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
public class TestePersistirContrato {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirContrato() {
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
            Contrato c = new Contrato();
            c.setSalario(4000);
            c.setStatus(true);
            c.setCargo(em.find(Cargo.class, 1));
            c.setFuncionario(em.find(Funcionario.class, 1));
            c.setDataAdm(new GregorianCalendar(2016, 2, 14, 20, 00));
            
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
