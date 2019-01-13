package nl.hanze.web.rdw.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RDWPersistence {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("RDW");
    protected EntityManager manager;
    protected EntityTransaction transaction;
 
    public RDWPersistence(){
    	this.manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    	this.transaction = manager.getTransaction();
    	this.transaction.begin();
    }

    public void close(){
    	transaction.commit();
    	manager.close();
    }
    
    public void endFactory(){
		ENTITY_MANAGER_FACTORY.close();
    }   
}

