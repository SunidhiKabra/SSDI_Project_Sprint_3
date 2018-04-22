package unitTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Customer;

public class TestCustomerModel {
	
	@Test
	public void returnNullValuesForDefaultConstructor() {
		Customer cust = new Customer();
		assertEquals(-1, cust.getID());
		assertEquals(null, cust.getFirstName());
		assertEquals(null, cust.getLastName());
		assertEquals(null, cust.getEmail());
		assertEquals(null, cust.getPassword());
		assertEquals(null, cust.getPhoneNumber());
	}
	@Test
	public void returnValuesWithoutId() {
		Customer cust = new Customer("fname", "lname", "email", "pass", "1234567");
		assertEquals(-1, cust.getID());
		assertEquals("fname", cust.getFirstName());
		assertEquals("lname", cust.getLastName());
		assertEquals("email", cust.getEmail());
		assertEquals("pass", cust.getPassword());
		assertEquals("1234567", cust.getPhoneNumber());
	}
	@Test
	public void returnValuesWithId() {
		Customer cust = new Customer(9, "fname", "lname", "email", "pass", "1234567");
		assertEquals(9, cust.getID());
		assertEquals("fname", cust.getFirstName());
		assertEquals("lname", cust.getLastName());
		assertEquals("email", cust.getEmail());
		assertEquals("pass", cust.getPassword());
		assertEquals("1234567", cust.getPhoneNumber());
	}
	@Test
	public void testCustomerID() {
		Customer cust = new Customer(9, "fname", "lname", "email", "pass", "1234567");
		assertEquals(9, cust.getID());
		cust.setID(10);
		assertEquals(10, cust.getID());
	}
	@Test
	public void testFirstName() {
		Customer cust = new Customer(9, "fname", "lname", "email", "pass", "1234567");
		assertEquals("fname", cust.getFirstName());
		cust.setFirstName("firstName");
		assertEquals("firstName", cust.getFirstName());
	}
	@Test
	public void testLastName() {
		Customer cust = new Customer(9, "fname", "lname", "email", "pass", "1234567");
		assertEquals("lname", cust.getLastName());
		cust.setLastName("lastName");
		assertEquals("lastName", cust.getLastName());
	}
	@Test
	public void testEmail() {
		Customer cust = new Customer(9, "fname", "lname", "email", "pass", "1234567");
		assertEquals("email", cust.getEmail());
		cust.setEmail("testEmail");
		assertEquals("testEmail", cust.getEmail());
	}
	@Test
	public void testPassword() {
		Customer cust = new Customer(9, "fname", "lname", "email", "pass", "1234567");
		assertEquals("pass", cust.getPassword());
		cust.setPassword("testPassword");
		assertEquals("testPassword", cust.getPassword());
	}
	@Test
	public void testPhone() {
		Customer cust = new Customer(9, "fname", "lname", "email", "pass", "1234567");
		assertEquals("1234567", cust.getPhoneNumber());
		cust.setPhoneNumber("54321");
		assertEquals("54321", cust.getPhoneNumber());
	}
}
