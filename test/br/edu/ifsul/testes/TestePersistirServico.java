/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Servico;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TestePersistirServico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();
        
        Servico s = new Servico();
        s.setDescricao("Ligações para VC1");
        s.setMascara("[7-9]\\d{7,8}");
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
