/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Localidade;
import br.edu.ifsul.modelo.UF;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TestePersistirLocalidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();
        Localidade l = new Localidade ();
        l.setDescricao("Rio Branco");
        UF uf = em.find(UF.class, 1);
        l.setUf(uf);
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
