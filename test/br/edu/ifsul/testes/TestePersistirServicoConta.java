/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Conta;
import br.edu.ifsul.modelo.ServicoConta;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TestePersistirServicoConta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();
        
        ServicoConta s = new ServicoConta();
        s.setCusto(100.0);
        s.setCustoReal(150.0);
        s.setData(new GregorianCalendar(2016, 3, 20));
        s.setDescricao("Franquia de Minutos Locais");
        s.setQuantidade(1000.0);
        s.setConta(em.find(Conta.class, 2));
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
