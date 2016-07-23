package com.kcomp;


import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		UserDAO userdao = new UserDAOImpDB();
		
		User u = new User("Kory", 23);
		User user2 = new User("Bob", 12);
		
		Book b = new Book();
		b.setName("Lord Of The Rings");
		u.addBook(b);
		u.addBook(new Book("Til The End"));
		
		user2.addBook(b);
		
		userdao.save(u);
		userdao.save(user2);
		
		u.setName("Paul");
		
		List<User> users = userdao.getUsers();
		
		for(User i : users){
			System.out.println(i.toString());
		}
		
		userdao.update(1, u);
		
		userdao.finish();
	    
	}

}
