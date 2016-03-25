/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Conta;
import br.edu.ifsul.modelo.Operadora;
import br.edu.ifsul.modelo.ServicoConta;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TestePersistirConta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();
        
        ServicoConta sc1 = new ServicoConta();
        sc1.setCusto(500.0);
        sc1.setCustoReal(700.0);
        sc1.setData(new GregorianCalendar(2010, 1, 20));
        sc1.setDescricao("Franquia de Internet");
        sc1.setQuantidade(100.0);
        
        ServicoConta sc2 = new ServicoConta();
        sc2.setCusto(1500.0);
        sc2.setCustoReal(1400.0);
        sc2.setData(new GregorianCalendar(2010, 1, 25));
        sc2.setDescricao("Franquia de Internet (2)");
        sc2.setQuantidade(200.0);
        
        Conta c = new Conta();
        c.setCustoTotal(1500.0);
        c.setDataFimPeriodo(new GregorianCalendar(2010, 2, 10));
        c.setDataIniPeriodo(new GregorianCalendar(2010, 1, 10));
        c.setDataVencimento(new GregorianCalendar(2010, 2, 25));
        c.setDescricao("Conta Teste 2");
        c.setOperadora(em.find(Operadora.class, 1));
        c.adicionarServico(sc1);
        c.adicionarServico(sc2);
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
