package unitTestCases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import api.AddItemController;
import api.CustomerController;
import api.EditInformationController;
import dao.DAO;
import model.Customer;

public class TestEditInformationController {
	@Mock
	HttpServletRequest req;
	@Mock
	DAO da;
	@Mock
	HttpSession hs;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void returnPageName() {
		DAO d = new DAO();
		EditInformationController eic = Mockito.spy(new EditInformationController(d));
		String expectedPage = "editInfo.do";
		assertEquals(expectedPage, eic.getName());
	}
	/*
	@Test
	public void showErrorsWithNullName() {
		Mockito.when(req.getParameter("name")).thenReturn(null);
		AddItemController aic = new AddItemController(da);
		ArrayList<String> errors = (ArrayList<String>) aic.getValidationErrors(req);
		String response = errors.get(0);
		String expectedError = "Item name is required";
		String nullResponse = null;
		String expectedNullError = req.getParameter("name");
		assertEquals(expectedError, response);
		assertEquals(expectedNullError, nullResponse);
	}
	*/
	@Test
	public void showErrorWithShortPassword() {
		Mockito.when(req.getParameter("firstName")).thenReturn("r");
		Mockito.when(req.getParameter("lastName")).thenReturn("k");
		Mockito.when(req.getParameter("email")).thenReturn("r@unc.edu");
		Mockito.when(req.getParameter("password")).thenReturn("small");
		Mockito.when(req.getParameter("phoneNumber")).thenReturn("123");
		
		EditInformationController eic = new EditInformationController(da);
		Customer cust = new Customer();
		ArrayList<String> errors = (ArrayList<String>) eic.getValidationErrors(req, cust);
		String response = errors.get(0);
		String expectedError = "Password should be minimum 6 characters";
		String shortResponse = "small";
		String expectedResponse = req.getParameter("password");
		assertEquals(response, expectedError);
		assertEquals(shortResponse, expectedResponse);
	}
	@Test
	public void showErrorWithNullPhoneNum() {
		Mockito.when(req.getParameter("firstName")).thenReturn("r");
		Mockito.when(req.getParameter("lastName")).thenReturn("k");
		Mockito.when(req.getParameter("email")).thenReturn("r@unc.edu");
		Mockito.when(req.getParameter("password")).thenReturn("password");
		Mockito.when(req.getParameter("phoneNumber")).thenReturn(null);
		
		EditInformationController eic = new EditInformationController(da);
		Customer cust = new Customer();
		ArrayList<String> errors = (ArrayList<String>) eic.getValidationErrors(req, cust);
		String response = errors.get(0);
		String expectedError = "Phone number is required";
		String shortResponse = null;
		String expectedResponse = req.getParameter("phoneNumber");
		assertEquals(response, expectedError);
		assertEquals(shortResponse, expectedResponse);
	}
	@Test
	public void showErrorWithEmptyPhoneNum() {
		Mockito.when(req.getParameter("firstName")).thenReturn("r");
		Mockito.when(req.getParameter("lastName")).thenReturn("k");
		Mockito.when(req.getParameter("email")).thenReturn("r@unc.edu");
		Mockito.when(req.getParameter("password")).thenReturn("password");
		Mockito.when(req.getParameter("phoneNumber")).thenReturn("");
		
		EditInformationController eic = new EditInformationController(da);
		Customer cust = new Customer();
		ArrayList<String> errors = (ArrayList<String>) eic.getValidationErrors(req, cust);
		String response = errors.get(0);
		String expectedError = "Phone number is required";
		String shortResponse = "";
		String expectedResponse = req.getParameter("phoneNumber");
		assertEquals(response, expectedError);
		assertEquals(shortResponse, expectedResponse);
	}
	@Test
	public void showErrorWithBadFormatPhoneNum() {
		Mockito.when(req.getParameter("firstName")).thenReturn("r");
		Mockito.when(req.getParameter("lastName")).thenReturn("k");
		Mockito.when(req.getParameter("email")).thenReturn("r@unc.edu");
		Mockito.when(req.getParameter("password")).thenReturn("password");
		Mockito.when(req.getParameter("phoneNumber")).thenReturn("123-4567");
		
		EditInformationController eic = new EditInformationController(da);
		Customer cust = new Customer();
		ArrayList<String> errors = (ArrayList<String>) eic.getValidationErrors(req, cust);
		String response = errors.get(0);
		String expectedError = "Phone number has to be numeric. No hypens/brackets";
		String shortResponse = "123-4567";
		String expectedResponse = req.getParameter("phoneNumber");
		assertEquals(response, expectedError);
		assertEquals(shortResponse, expectedResponse);
	}
	
	
}
