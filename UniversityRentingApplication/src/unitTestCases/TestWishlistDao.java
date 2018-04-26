package unitTestCases;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import dao.CustomerDao;
import dao.ItemDao;
import dao.WishlistDao;
import model.Customer;
import model.IItem;
import model.Item;
import model.Wishlist;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class TestWishlistDao {
	@Mock
	private Connection c;
	
	private ConnectionData cdata = new ConnectionData();
	private WishlistDao wdTest = new WishlistDao(cdata);
	private CustomerDao cdTest = new CustomerDao(cdata);
	private ItemDao idTest = new ItemDao(cdata);
	
	@Before
	public void setUp() throws Exception {
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDemo", "root", "test");
		c.createStatement();
	}
	@After
	public void tearDown() throws Exception {
		
	}
	private int setUpCustId() {
		ResultSet rsCustomer = null;
		PreparedStatement psCustomer = null;
		String sqlCustomer = "SELECT * FROM Customer";
		Customer testCust = new Customer("r","k","rohankap@uncc.edu","pass","12345678");
		cdTest.addCustomer(testCust);
		int idCust = 0;
		try {
			psCustomer = c.prepareStatement(sqlCustomer);
			rsCustomer = psCustomer.executeQuery();
			rsCustomer.next();
			idCust = rsCustomer.getInt("id");
			testCust.setID(idCust);
		} catch (SQLException e1) {
			
		}
		return idCust;
	}
	private int setUpItemId(int idCust) {
		ResultSet rsItem = null;
		PreparedStatement psItem = null;
		String sqlItem = "SELECT * FROM Item";
		//int idCust = setUpCustId();
		Item testItem = new Item(idCust,"phone","google",(float) 95.00, true);
		idTest.addItem(testItem);
		int idItem = 0;
		try {
			psItem = c.prepareStatement(sqlItem);
			rsItem = psItem.executeQuery();
			rsItem.next();
			idItem = rsItem.getInt("id");
		} catch(SQLException e) {
			
		}
		return idItem;
	}
	private void deleteFromCust() {
		ConnectionData connData = new ConnectionData();
		Connection conn = ConnectionUtility.getConnection(connData);
		PreparedStatement pDelete = null;
		String sqlDelete = "delete from Customer where emailID = ?;";
		try {
			pDelete = conn.prepareStatement(sqlDelete);
			pDelete.setString(1, "rohankap@uncc.edu");
			pDelete.executeUpdate();
		} catch (SQLException e) {
			
		}
	}
	private void deleteFromItem() {
		ConnectionData connData = new ConnectionData();
		Connection conn = ConnectionUtility.getConnection(connData);
		PreparedStatement pDelete = null;
		String sqlDelete = "delete from Item where name = ?";
		try {
			pDelete = conn.prepareStatement(sqlDelete);
			pDelete.setString(1, "phone");
			pDelete.executeUpdate();
		} catch (SQLException e) {
			
		}
	}
	private void deleteFromWishList() {
		ConnectionData connData = new ConnectionData();
		Connection conn = ConnectionUtility.getConnection(connData);
		PreparedStatement pDelete = null;
		String sqlDelete = "DELETE FROM Wishlist";
		try {
			pDelete = conn.prepareStatement(sqlDelete);
			pDelete.executeUpdate();
		} catch(SQLException e) {
			
		}
	}
	@Test
	public void testAddToWishListItem() {
		//before
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = null;
		//create model
		Wishlist w = new Wishlist();
		int idCust = setUpCustId();
		int idItem = setUpItemId(idCust);
		w.setCustomerId(idCust);
		w.setItemId(idItem);
		//add to dao class
		try {
			wdTest.addItemToWishList(w);
			sql = "SELECT * FROM Wishlist";
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			assertEquals(true,rs.next());
			assertEquals(idCust,rs.getInt("customerID"));
			assertEquals(idItem,rs.getInt("itemID"));
		}catch(SQLException e) {
			assertFalse(true);
		}
		
		deleteFromWishList();
		deleteFromCust();
		deleteFromItem();
		
	}
	@Test
	public void testGetWishlist() {
		
		Wishlist w = new Wishlist();
		int idCust = setUpCustId();
		int idItem = setUpItemId(idCust);
		w.setCustomerId(idCust);
		w.setItemId(idItem);
		wdTest.addItemToWishList(w);
		
		List<IItem> i = wdTest.getItems(idCust);
		assertEquals(1,i.size());
		assertEquals(idCust,i.get(0).getCustomerId());
		assertEquals(idItem,i.get(0).getId());
		
		deleteFromWishList();
		deleteFromCust();
		deleteFromItem();
	}
	@Test
	public void testDeleteWishlist() {

		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = null;
		
		Wishlist w = new Wishlist();
		int idCust = setUpCustId();
		int idItem = setUpItemId(idCust);
		w.setCustomerId(idCust);
		w.setItemId(idItem);
		
		wdTest.addItemToWishList(w);
		sql = "SELECT * FROM Wishlist";
		try {
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			assertEquals(true,rs.next());
		}
		catch(SQLException e) {}
		
		wdTest.deleteItemById(idItem, idCust);
		List<IItem> i = wdTest.getItems(idCust);
		assertEquals(0,i.size());
		
		deleteFromWishList();
		deleteFromCust();
		deleteFromItem();
	}
}
