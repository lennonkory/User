package com.kcomp;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int idUser;
	
	private String name;
	private int age;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	List<Book> books = new ArrayList<>();
	
	public User(){}
	
	public User(int id, String name, int age){
		this.idUser = id;
		this.name = name;
		this.age = age;
	}
	
	public User(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", age=" + age + ", books=" + books + "]";
	}

	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void addBook(Book b){
		books.add(new Book(b));
	}
	
}
