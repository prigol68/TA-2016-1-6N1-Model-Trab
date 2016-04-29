package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Escolaridade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.modelo.Usuario;
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
public class TestePersistirTelefone {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirTelefone() {
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
            Usuario usu = em.find(Usuario.class, 1);
            Telefone t = new Telefone();
            t.setNumero("(54) 9999 9999");
            t.setOperadora("21");
            t.setDescricao("Celular");
            usu.adicionarTelefone(t);
            
            em.getTransaction().begin();
            em.persist(usu);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
