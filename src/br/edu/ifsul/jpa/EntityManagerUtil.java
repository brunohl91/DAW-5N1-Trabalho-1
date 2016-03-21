
package br.edu.ifsul.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class EntityManagerUtil {
    
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;
    
    public static EntityManager getEntityManager () {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-Trabalho-1");
        }
        if (em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }
    
}
