package com.kcomp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int idUser;
	
	private String name;
	private int age;
	
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
}
