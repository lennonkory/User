package com.kcomp;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestUserDAO extends TestCase {

	private UserDAO userdao;
	
	public TestUserDAO(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		userdao = new UserDAOImpFile();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testUserDAOImpFile() {
		
	}

	public void testSave() {
		User u = new User(3, "Bob", 23);
		boolean saved = userdao.save(u);
		Assert.assertTrue(saved);
	}

	public void testGetUser() {
		User u = userdao.getUser(1);
		
		Assert.assertNotNull(u);
		Assert.assertEquals(1, u.getIdUser());
	}

	public void testGetUsers() {
		
	}

	public void testUpdate() {
		
	}

	public void testDelete() {
		
	}

}
