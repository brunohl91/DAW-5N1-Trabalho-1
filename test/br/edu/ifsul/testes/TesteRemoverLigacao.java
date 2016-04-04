/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Conta;
import br.edu.ifsul.modelo.Ligacao;
import br.edu.ifsul.modelo.Operadora;
import br.edu.ifsul.modelo.Prefixo;
import br.edu.ifsul.modelo.Ramal;
import br.edu.ifsul.modelo.Senha;
import br.edu.ifsul.modelo.Servico;
import br.edu.ifsul.modelo.ServicoConta;
import br.edu.ifsul.modelo.Tarifa;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TesteRemoverLigacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();

        Ligacao l = new Ligacao();
        l.setData(new GregorianCalendar(2016, 4, 4));
        l.setDuracao(94);
        l.setDiscado("005484080633");
        l.setRamal("2103");
        l.setSenha("3014");
        l.setErro("OK");
        l.setCusto(1.54);
        l.setTarifa(em.find(Tarifa.class, 2));
        l.setServico(em.find(Servico.class, 2));
        l.setSenhaLigacao(em.find(Senha.class, 3));
        l.setPrefixo(em.find(Prefixo.class, 2));
        l.setConta(em.find(Conta.class, 3));
        
        Ramal r = em.find(Ramal.class, 1);
        l.adicionarRamal(r);
        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
