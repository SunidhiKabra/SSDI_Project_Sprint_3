package unitTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utilities.ConnectionData;

public class TestConnectionData {
	
	@Test
	public void returnUrl() {
		ConnectionData cd = new ConnectionData();
		String url = "jdbc:mysql://localhost:3306/testDemo";
		assertEquals(url, cd.getUrl());
	}
	@Test
	public void returnUser() {
		ConnectionData cd = new ConnectionData();
		String user = "root";
		assertEquals(user, cd.getUser());
	}
	@Test
	public void returnPassword() {
		ConnectionData cd = new ConnectionData();
		String pass = "test";
		assertEquals(pass, cd.getPassword());
	}
}
