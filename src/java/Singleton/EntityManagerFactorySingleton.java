/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author proto
 */
public class EntityManagerFactorySingleton {
    
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getInstance() {
    
        if (emf == null) {
        
            emf = Persistence.createEntityManagerFactory("vitrinePU");
            
        }
        
        return emf;
    }
}
