package com.kcomp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOImpDB implements UserDAO{
	
	private EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("test-jpa");
	
  
	
	@Override
	public boolean save(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(user);
		transaction.commit();
		em.close();
		return true;
	}

	@Override
	public User getUser(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		User u = em.find(User.class, id);
		transaction.commit();
		em.close();
		return u;
	}

	@Override
	public List<User> getUsers() {
		EntityManager em = entityManagerFactory.createEntityManager();	    
		Query q = em.createQuery("SELECT u FROM User u");
		return q.getResultList();
	}

	@Override
	public boolean update(int id, User user) {
		 
		EntityManager em = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(user);
		transaction.commit();
		em.close();
		return true;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finish() {
		//em.close();
		
	}



}
