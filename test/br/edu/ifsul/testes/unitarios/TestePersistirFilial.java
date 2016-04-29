package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Filial;
import br.edu.ifsul.modelo.Funcionario;
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
public class TestePersistirFilial {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirFilial() {
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
            Filial f = new Filial();
            f.setNome("IFSUL");
            f.setNomeFantasia("Instituto Federal");
            f.setEndereco("Rua: Teste");
            f.setCnpj("46.446.239/0001-90");
            f.setFuncionario(em.find(Funcionario.class, 1));
            
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
