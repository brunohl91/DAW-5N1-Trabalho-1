/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Identificador;
import br.edu.ifsul.modelo.Operadora;
import br.edu.ifsul.modelo.Ramal;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.modelo.VigenciaIdentificador;
import br.edu.ifsul.modelo.VigenciaIdentificadorID;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class TestePersistirVigencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        EntityManager em = emf.createEntityManager();
        
        VigenciaIdentificadorID vId = new VigenciaIdentificadorID();
        vId.setIdentificador(em.find(Ramal.class, 1));
        vId.setUsuario(em.find(Usuario.class, 1));
        
        VigenciaIdentificador v = new VigenciaIdentificador();
        v.setVigenciaId(vId);
        v.setDataIni(new GregorianCalendar(2016, 4, 4));
        
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
