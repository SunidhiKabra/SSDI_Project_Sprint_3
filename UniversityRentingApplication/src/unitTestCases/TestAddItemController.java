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
import dao.DAO;

public class TestAddItemController {
	@Mock
	HttpServletRequest req;
	@Mock
	DAO da;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void returnPageName() {
		DAO d = new DAO();
		AddItemController aic = Mockito.spy(new AddItemController(d));
		String expectedPage = "addItems.do";
		assertEquals(expectedPage, aic.getName());
	}
	
	@Test
	public void returnNewPageName() throws IOException, ServletException{
		Mockito.when(req.getParameter("name")).thenReturn("phone");
		AddItemController aic = new AddItemController(da);
		String expectedPage = aic.perform(req);
		assertEquals("addItems.jsp", expectedPage);
	}
	
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
	
	@Test
	public void showErrorsWithEmptyName() {
		Mockito.when(req.getParameter("name")).thenReturn("");
		AddItemController aic = new AddItemController(da);
		ArrayList<String> errors = (ArrayList<String>) aic.getValidationErrors(req);
		int response = req.getParameter("name").length();
		int expectedError = 0;
		String messageResponse = errors.get(0);
		String expectedMessageError = "Item name is required";
		assertEquals(expectedError, response);
		assertEquals(expectedMessageError,messageResponse);
	}
	
	@Test
	public void showErrorsWithNullRent() {
		Mockito.when(req.getParameter("name")).thenReturn("rohan");
		Mockito.when(req.getParameter("rent")).thenReturn(null);
		AddItemController aic = new AddItemController(da);
		ArrayList<String> errors = (ArrayList<String>) aic.getValidationErrors(req);
		String response = errors.get(0);
		String expectedError = "Item rent is required";
		String nullResponse = null;
		String expectedNullError = req.getParameter("rent");
		assertEquals(expectedError, response);
		assertEquals(expectedNullError, nullResponse);
	}
	
	@Test
	public void showErrorsWithEmptyRent() {
		Mockito.when(req.getParameter("name")).thenReturn("rohan");
		Mockito.when(req.getParameter("rent")).thenReturn("");
		AddItemController aic = new AddItemController(da);
		ArrayList<String> errors = (ArrayList<String>) aic.getValidationErrors(req);
		int response = req.getParameter("rent").length();
		int expectedError = 0;
		String messageResponse = errors.get(0);
		String expectedMessageError = "Item rent is required";
		assertEquals(expectedError, response);
		assertEquals(expectedMessageError,messageResponse);
	}
	
	@Test
	public void showErrorsWithStringRent() {
		Mockito.when(req.getParameter("name")).thenReturn("rohan");
		Mockito.when(req.getParameter("rent")).thenReturn("hello");
		AddItemController aic = new AddItemController(da);
		ArrayList<String> errors = (ArrayList<String>) aic.getValidationErrors(req);
		String messageResponse = errors.get(0);
		String expectedMessageError = "Item rent has to be numeric";
				assertEquals(expectedMessageError,messageResponse);
	}
	
}
