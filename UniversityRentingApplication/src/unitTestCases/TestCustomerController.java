package unitTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import api.AddItemController;
import api.CustomerController;
import dao.DAO;
import model.Customer;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class TestCustomerController {
	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse resp;
	@Mock
	DAO da;
	@Mock
	Customer cust;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void checkCustomer() throws ServletException, IOException, SQLException{
		Customer cust = new Customer();
		CustomerController cc = new CustomerController();
		Mockito.when(req.getParameter("firstName")).thenReturn("rohan");
		Mockito.when(req.getParameter("lastName")).thenReturn("kapoor");
		Mockito.when(req.getParameter("email")).thenReturn("email");
		Mockito.when(req.getParameter("password")).thenReturn("pass");
		Mockito.when(req.getParameter("phoneNumber")).thenReturn("123");
		
		cc.doGet(req, resp);
		
		
		String fn = req.getParameter("firstName");
		String ln = req.getParameter("lastName");
		String e = req.getParameter("email");
		String p = req.getParameter("password");
		String ph = req.getParameter("123");
		
		cust.setFirstName(fn);
		cust.setLastName(ln);
		cust.setEmail(e);
		cust.setPassword(p);
		cust.setPhoneNumber(ph);
		
		assertEquals(fn,cust.getFirstName());
		assertEquals(ln, cust.getLastName());
		assertEquals(e, cust.getEmail());
		assertEquals(p, cust.getPassword());
		assertEquals(ph, cust.getPhoneNumber());
		
		
		PreparedStatement p2 = null;
		String sql2 = null;
		ConnectionData connData = new ConnectionData();
		Connection conn = ConnectionUtility.getConnection(connData);
		try {
			sql2 = "delete from Customer where emailID = ?";
			p2 = conn.prepareStatement(sql2);
			p2.setString(1, "email");
			p2.executeUpdate();
		}
		catch (SQLException ex) {
			assertFalse(true);
		}
		
	}
	
}
