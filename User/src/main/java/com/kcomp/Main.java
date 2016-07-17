package com.kcomp;


import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) throws SQLException {
		EntityManagerFactory entityManagerFactory = 
	            Persistence.createEntityManagerFactory("test-jpa");
	   System.out.println(entityManagerFactory.isOpen());
	    EntityManager em = entityManagerFactory.createEntityManager();
	    
	    EntityTransaction transaction = em.getTransaction();

	    transaction.begin();
	    User u = new User("Bob", 42);
	    User u2 = new User("Sam", 26);
	    em.persist(u);
	    em.persist(u2);
	    transaction.commit();
	    
	    em.close();
	    
	}

}
