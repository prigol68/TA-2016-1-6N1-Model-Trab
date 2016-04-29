package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Setor;
import br.edu.ifsul.modelo.Usuario;

import java.util.Calendar;
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
public class TestePersistirAtua {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAtua() {
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
    public void teste() {
        boolean exception = false;
        try {
            Usuario obj = em.find(Usuario.class, 1);
            Setor s = em.find(Setor.class, 1);
            
            obj.getAtuado().add(s);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
