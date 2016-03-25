/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Operadora;
import br.edu.ifsul.modelo.Tarifa;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TestePersistirTarifa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();
        
        Tarifa t = new Tarifa ();
        t.setCusto(0.40);
        t.setInicioVigencia(new GregorianCalendar(2001, 12, 20));
        t.setFimVigencia(new GregorianCalendar(2050, 6, 1));
        t.setOperadora(em.find(Operadora.class, 1));
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
