package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.CargaHoraria;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Escolaridade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Setor;
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
public class TestePersistirUsuario {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirUsuario() {
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
            Usuario obj = new Usuario();
            obj.setNome("Fulano Teste");
            obj.setBairro("Centro");
            obj.setCidade(em.find(Cidade.class, 1));
            obj.setComplemento("Ap");
            obj.setEmail("teste@hotmail.com");
            obj.setEndereco("Rua JJJJJ");
            obj.setApelido("full");
            obj.setSenha("456");
            
            obj.setAdministrador(false);
            obj.setAtivo(true);
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);// verifico se o esperado ocorreu
    }
}
