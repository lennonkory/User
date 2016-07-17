package com.kcomp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOImpDB implements UserDAO{

	@PersistenceContext
	private EntityManager entityManager;
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean save(User user) {
		entityManager.persist(user);
		return true;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(int id, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setJdbcTemplate(JdbcTemplate j) {
		this.jdbcTemplate = j;
	}

}
