package com.kcomp;

import java.util.List;

public interface UserDAO {

	public boolean save(User user);
	public User getUser(int id);
	public List<User> getUsers();
	public boolean update(int id, User user);
	public boolean delete(int id);
	public void finish();
}
