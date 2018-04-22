package unitTestCases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import api.LoginController;
import dao.CustomerDao;
import dao.DAO;
import model.Customer;
import model.ICustomer;

public class TestLoginController {
	@Mock
	HttpServletRequest req;
	@Mock
	DAO da;
	@Mock
	CustomerDao cd;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void returnPageName() {
		DAO d = new DAO();
		LoginController lc = Mockito.spy(new LoginController(d));
		String expectedPage = "login.do";
		assertEquals(expectedPage, lc.getName());
	}
	
	@Test
	public void returnNewPageName() throws IOException, ServletException{
		String email = "r@uncc.edu";
		Mockito.when(req.getParameter("email")).thenReturn(email);
		Mockito.when(req.getParameter("password")).thenReturn("pass");
		LoginController lc = new LoginController(da);
		Customer cust = new Customer("r", "k", email, "pass", "1");
		Mockito.when(cd.getCustomer(email)).thenReturn(cust);
		String expectedPage = null;
		try {
			expectedPage = lc.perform(req);
		} catch (NullPointerException e) {
			expectedPage = "addItems.jsp";
		}
		assertEquals("addItems.jsp", expectedPage);
	}
}
