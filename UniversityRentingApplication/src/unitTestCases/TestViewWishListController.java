package unitTestCases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import api.ViewWishlistController;
import dao.DAO;
import dao.WishlistDao;
import model.Customer;
import model.IItem;

public class TestViewWishListController {
	@Mock
	DAO d = new DAO();
	@Mock
	HttpServletRequest r;
	@Mock
	HttpSession s;
	@Mock
	WishlistDao w = new WishlistDao();
	@Test
	public void testViewItem() {
		HttpServletRequest stubR = Mockito.mock(HttpServletRequest.class);
		HttpSession stubS = Mockito.mock(HttpSession.class);
		Customer cust = new Customer(1,"ro","kap","r@uncc.edu","pass","123456");
		Mockito.when(stubR.getSession(true)).thenReturn(stubS);
		Mockito.when(stubR.getSession()).thenReturn(null);
		Mockito.when(stubS.getAttribute("loggedInUser")).thenReturn(cust);
		
		
		ViewWishlistController a = new ViewWishlistController(d);
		
		
		
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
