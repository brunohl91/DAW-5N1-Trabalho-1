/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Conta;
import br.edu.ifsul.modelo.ServicoConta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TesteBuscarConta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();

        Conta c = em.find(Conta.class, 3);
        System.out.println(c.getCustoTotal());
        System.out.println(c.getDescricao());
        List<ServicoConta> sc = c.getServicos();
        
        for (ServicoConta s : sc) {
            System.out.println(s.getDescricao());
        }
        
        em.close();
        emf.close();
    }
    
}
