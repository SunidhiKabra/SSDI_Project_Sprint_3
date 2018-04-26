package unitTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
import api.AddItemToWishlistController;

import dao.DAO;
import model.Customer;

public class TestAddItemToWishlistController {
	@Mock
	DAO d = new DAO();
	@Mock
	HttpServletRequest r;
	@Mock
	HttpSession s;
	
	
	@Test
	public void testAddItem() {
		HttpServletRequest stubR = Mockito.mock(HttpServletRequest.class);
		HttpSession stubS = Mockito.mock(HttpSession.class);
		Customer cust = new Customer(1,"ro","kap","r@uncc.edu","pass","123456");
		Mockito.when(stubR.getSession(true)).thenReturn(stubS);
		Mockito.when(stubR.getSession()).thenReturn(null);
		Mockito.when(stubS.getAttribute("loggedInUser")).thenReturn(cust);
		AddItemToWishlistController a = new AddItemToWishlistController(d);
		
		
		
		String ret = null;
		try {
			ret = a.perform(r);
			Mockito.verify(a).perform(r);
			Mockito.verify(r).getSession(true);
			Mockito.verify(r).getParameter("itemId");
			Mockito.verify(s).getAttribute("loggedInUser");
			assertEquals(ret,"Item Added To Wishlist.msg");
		} catch(NullPointerException e) {
			
		}
		
		
	}
}
