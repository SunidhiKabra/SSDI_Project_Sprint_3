package unitTestCases;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import dao.CustomerDao;
import model.Customer;
import model.ICustomer;
import utilities.ConnectionData;
import utilities.ConnectionUtility;


public class TestCustomerDao {
	
	@Mock
	private DataSource ds;
	@Mock
	private Connection c;
	//@Mock
	//private PreparedStatement stmt;
	@Mock
	private CustomerDao cd;
	//@Mock
	//ConnectionData connData;
	
	private ConnectionData cdata = new ConnectionData();
	private CustomerDao cdTest = new CustomerDao(cdata);
	
	
	@Before
	public void setUp() throws Exception {
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDemo", "root", "test");
		c.createStatement();
	}
	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	public void showNewCustomer() {
		ResultSet rs = null;
		PreparedStatement p = null;
		String sql=null;
		try {
			Customer testCust = new Customer("rohan","kapoor","r@uncc.edu","pass","1234567");
			cdTest.addCustomer(testCust);
			sql = "SELECT * FROM Customer";
			p = c.prepareStatement(sql);
			rs = p.executeQuery();
			assertEquals(true, rs.next());
			assertEquals("rohan", rs.getString("firstName"));
			assertEquals("kapoor", rs.getString("lastName"));
			assertEquals("r@uncc.edu", rs.getString("emailID"));
			assertEquals("pass", rs.getString("password"));
			assertEquals("1234567", rs.getString("phoneNumber"));
		}
		catch (SQLException e) {
			assertFalse(true);
		}
		PreparedStatement p2 = null;
		String sql2 = null;
		ConnectionData connData = new ConnectionData();
		Connection conn = ConnectionUtility.getConnection(connData);
		try {
			sql2 = "delete from Customer where emailID = ?";
			p2 = conn.prepareStatement(sql2);
			p2.setString(1, "r@uncc.edu");
			p2.executeUpdate();
		}
		catch (SQLException e) {
			assertFalse(true);
		}
	}
	@Test
	public void getCustomerByEmail() {
		
		try {
			Customer testCust = new Customer("rohan","kapoor","rk@uncc.edu","pass","1234567");
			cdTest.addCustomer(testCust);
			ICustomer returnCust = cdTest.getCustomer("rk@uncc.edu");
			assertEquals(testCust.getFirstName(), returnCust.getFirstName());
			assertEquals(testCust.getEmail(), returnCust.getEmail());
			assertEquals(testCust.getLastName(), returnCust.getLastName());
			assertEquals(testCust.getPassword(), returnCust.getPassword());
			assertEquals(testCust.getPhoneNumber(), returnCust.getPhoneNumber());
			
		}
		catch (Exception e) {
			assertFalse(true);
		}
		PreparedStatement p2 = null;
		String sql2 = null;
		ConnectionData connData = new ConnectionData();
		Connection conn = ConnectionUtility.getConnection(connData);
		try {
			sql2 = "delete from Customer where emailID = ?";
			p2 = conn.prepareStatement(sql2);
			p2.setString(1, "rk@uncc.edu");
			p2.executeUpdate();
		}
		catch (SQLException e) {
			assertFalse(true);
		}
	}
	
	@Test
	public void editCustomer() {
		ResultSet rs = null;
		PreparedStatement p = null;
		String sql=null;
		try {
			Customer testCust = new Customer("roro","kapo","rkap@uncc.edu","pass123","1237");
			cdTest.addCustomer(testCust);
			
			sql="SELECT * FROM Customer";
			p = c.prepareStatement(sql);
			rs = p.executeQuery();
			rs.next();
			
			int id = rs.getInt("id");
			testCust.setID(id);
			testCust.setFirstName("newFirst");
			testCust.setLastName("newLast");
			testCust.setEmail("newEmail");
			Customer editCust = new Customer(testCust.getID(), testCust.getFirstName(), testCust.getLastName(), testCust.getEmail(), testCust.getPassword(), testCust.getPhoneNumber());
			cdTest.setCustomer(editCust);
			
			sql="SELECT * FROM Customer";
			p = c.prepareStatement(sql);
			rs = p.executeQuery();
			
			assertEquals(true, rs.next());
			assertEquals("newFirst", rs.getString("firstName"));
			assertEquals("newLast", rs.getString("lastName"));
			assertEquals("newEmail", rs.getString("emailID"));
			assertEquals("pass123", rs.getString("password"));
			assertEquals("1237", rs.getString("phoneNumber"));
		}
		catch (SQLException e) {
			assertFalse(true);
		}
		
		PreparedStatement p2 = null;
		String sql2 = null;
		ConnectionData connData = new ConnectionData();
		Connection conn = ConnectionUtility.getConnection(connData);
		try {
			sql2 = "delete from Customer where emailID = ?";
			p2 = conn.prepareStatement(sql2);
			p2.setString(1, "rkap@uncc.edu");
			p2.executeUpdate();
		}
		catch (SQLException e) {
			assertFalse(true);
		}
		PreparedStatement p3 = null;
		String sql3 = null;
		
		try {
			sql3 = "delete from Customer where emailID = ?";
			p3 = conn.prepareStatement(sql2);
			p3.setString(1, "newEmail");
			p3.executeUpdate();
		}
		catch (SQLException e) {
			assertFalse(true);
		}
	}
}
