/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Operadora;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TestePersistirOperadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();
        
        Operadora o = new Operadora();
        o.setCodigoDiscagem("015");
        o.setNome("VIVO");
        o.setTipo("Móvel");
        
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
