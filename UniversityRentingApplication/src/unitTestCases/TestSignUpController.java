package unitTestCases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import api.AddItemController;
import api.SignUpController;
import dao.CustomerDao;
import dao.DAO;
import model.Customer;
import model.ICustomer;

public class TestSignUpController {
	@Mock
	HttpServletRequest req;
	@Mock
	DAO da;
	@Mock
	ICustomer c;
	@Mock
	CustomerDao cdao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void returnPageName() {
		DAO d = new DAO();
		SignUpController sc = Mockito.spy(new SignUpController(d));
		String expectedPage = "signUp.do";
		assertEquals(expectedPage, sc.getName());
	}
	@Test
	public void showErrorsWithNullFields() {
		Mockito.when(req.getParameter("firstName")).thenReturn(null);
		Mockito.when(req.getParameter("lastName")).thenReturn(null);
		Mockito.when(req.getParameter("email")).thenReturn(null);
		Mockito.when(req.getParameter("password")).thenReturn(null);
		Mockito.when(req.getParameter("phoneNumber")).thenReturn(null);
		
		SignUpController sc = new SignUpController(da);
		ArrayList<String> errors = (ArrayList<String>) sc.getValidationErrors(req);
		String response = errors.get(0);
		String expectedError = "All fields are mandatory";
		String nullResponse = null;
		String expectedFirstName = req.getParameter("firstName");
		String expectedLastName = req.getParameter("firstName");
		String expectedEmail = req.getParameter("firstName");
		String expectedPassword = req.getParameter("firstName");
		String expectedPhoneNum = req.getParameter("firstName");
		
		assertEquals(expectedError, response);
		assertEquals(expectedFirstName, nullResponse);
		assertEquals(expectedLastName, nullResponse);
		assertEquals(expectedEmail, nullResponse);
		assertEquals(expectedPassword, nullResponse);
		assertEquals(expectedPhoneNum, nullResponse);
	}
	/*
	@Test
	public void showErrorWithNullEmail() {
		Mockito.when(req.getParameter("firstName")).thenReturn("r");
		Mockito.when(req.getParameter("lastName")).thenReturn("k");
		Mockito.when(req.getParameter("email")).thenReturn(null);
		Mockito.when(req.getParameter("password")).thenReturn("password");
		Mockito.when(req.getParameter("phoneNumber")).thenReturn("123");
		
		CustomerDao cd = Mockito.spy(new CustomerDao());
		ICustomer cust = cd.getCustomer(null);
		Mockito.when(cd.getCustomer(null)).thenReturn(null);
		SignUpController sc = new SignUpController(da);
		ArrayList<String> errors = (ArrayList<String>) sc.getValidationErrors(req);
		String response = errors.get(0);
		String expectedError = "Email-id is required";
		assertEquals(expectedError,response);
	}*/
}