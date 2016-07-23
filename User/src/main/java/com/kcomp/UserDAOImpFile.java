package com.kcomp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOImpFile implements UserDAO{

	private static final Logger log = Logger.getLogger(UserDAOImpFile.class.getName());
	
	private File file;
	private Scanner fileScanner;
	
	List<User> users;
	
	public UserDAOImpFile(){
		
		super();
		users = new ArrayList<>();
		this.file = new File(System.getProperty("user.dir") + "/src/main/resources/userFile");
		
		if(this.file.exists()){
			log.info("Reading from file");
			
			this.readFromFile();
		}
		else{
			log.info("Creating User file");
			try {
				this.file.createNewFile();
				fileScanner = new Scanner(file);
			} catch (IOException e) {
				log.severe("Error creating User file");
				e.printStackTrace();
			}
		}

	}
	
	private void readFromFile(){
		
		try {
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		while(fileScanner.hasNextLine()){
			String userLine = fileScanner.nextLine();
			String [] parts = userLine.split(":");
			User u = new User();
			u.setIdUser(Integer.parseInt(parts[0]));
			u.setName(parts[1]);
			u.setAge(Integer.parseInt(parts[2]));
			users.add(u);
		}
		
	}
	
	@Override
	public boolean save(User user) {
		users.add(user);
		return true;
	}

	@Override
	public User getUser(int id) {
		for(User u : users){
			if(u.getIdUser() == id){
				return u;
			}
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public boolean update(int id, User user) {
		for(User u : users){
			if(u.getIdUser() == id){
				u.setAge(user.getAge());
				u.setIdUser(user.getIdUser());
				u.setName(user.getName());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		for(User u : users){
			if(u.getIdUser() == id){
				users.remove(u);
				return true;
			}
		}
		return false;
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
