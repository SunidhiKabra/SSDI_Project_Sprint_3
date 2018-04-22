//package unitTestCases;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import java.util.List;
//import dao.CustomerDao;
//import dao.ItemDao;
//import model.Customer;
//import model.IItem;
//import model.Item;
//import utilities.ConnectionData;
//import utilities.ConnectionUtility;
//
//public class TestItemDao {
//
//	@Mock
//	private DataSource ds;
//	@Mock
//	private Connection c;
//	@Mock
//	private PreparedStatement stmt;
//	@Mock
//	private CustomerDao cd;
//	
//	private ConnectionData cdata = new ConnectionData();
//	private ItemDao idTest = new ItemDao(cdata);
//	
//	@Before
//	public void setUp() throws Exception {
//		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDemo", "root", "test");
//		c.createStatement();
//	}
//	@After
//	public void tearDown() throws Exception {
//		
//	}
//	@Test
//	public void showNewItem() {
//		
//		PreparedStatement p2 = null;
//		String sql2 = null;
//		ConnectionData connData = new ConnectionData();
//		Connection conn = ConnectionUtility.getConnection(connData);
//		try {
//			sql2 = "delete from Item where customerId = ?";
//			p2 = conn.prepareStatement(sql2);
//			p2.setInt(1, -1);
//			p2.executeUpdate();
//		}
//		catch (SQLException e) {
//			assertFalse(true);
//		}
//		
//		ResultSet rs = null;
//		PreparedStatement p = null;
//		String sql = null;
//		try {
//			Item testItem = new Item(6, "phone", "apple", (float) 80.00, true);
//			idTest.addItem(testItem);
//			sql = "SELECT * FROM Item";
//			p = c.prepareStatement(sql);
//			rs = p.executeQuery();
//			assertEquals(true, rs.next());
//			assertEquals(6, rs.getInt("customerID"));
//			assertEquals("phone", rs.getString("name"));
//			assertEquals("apple", rs.getString("description"));
//			assertEquals(80.00, rs.getFloat("rent"), 0);
//		}
//		catch (SQLException e) {
//			assertFalse(true);
//		}
//		finally {
//			
//		}
//		
//		
//	}
//	@Test
//	public void showAllItems() {
//		
//		try {
//			Item testCust = new Item(7,"laptop","dell",(float)95.00, true);
//			idTest.addItem(testCust);
//			List<IItem> returnItemList = idTest.getItems();
//			//assertEquals(2, returnItemList.size());
//			assertEquals("laptop", returnItemList.get(1).getName());
//			assertEquals("phone", returnItemList.get(0).getName());
//			assertEquals("apple", returnItemList.get(0).getDescription());
//			
//		}
//		catch (Exception e) {
//			assertFalse(true);
//		}
//		
//		PreparedStatement p2 = null;
//		String sql2 = null;
//		ConnectionData connData = new ConnectionData();
//		Connection conn = ConnectionUtility.getConnection(connData);
//		try {
//			sql2 = "delete from Item where customerId = ?";
//			p2 = conn.prepareStatement(sql2);
//			p2.setInt(1, 6);
//			p2.executeUpdate();
//		}
//		catch (SQLException e) {
//			assertFalse(true);
//		}
//		try {
//			sql2 = "delete from Item where customerId = ?";
//			p2 = conn.prepareStatement(sql2);
//			p2.setInt(1, 7);
//			p2.executeUpdate();
//		}
//		catch (SQLException e) {
//			assertFalse(true);
//		}
//	}
//	@Test
//	public void showCustomerItems() {
//		Item testItem = new Item(6, "phone", "apple", (float) 80.00, true);
//		Item testItem2 = new Item(6, "laptop", "apple", (float) 80.00, true);
//		idTest.addItem(testItem);
//		idTest.addItem(testItem2);
//		
//		List<IItem> items = idTest.getItemsByOwner(6);
//		
//		assertEquals(2, items.size());
//		assertEquals("phone", items.get(0).getName());
//		assertEquals("laptop", items.get(1).getName());
//	}
//	
//	@Test
//	public void editItem() {
//		ResultSet rs = null;
//		PreparedStatement p = null;
//		String sql=null;
//		try {
//			Item testCust = new Item(6, "phone","samsung",(float) 45.05, true);
//			idTest.addItem(testCust);
//			
//			sql="SELECT * FROM Item";
//			p = c.prepareStatement(sql);
//			rs = p.executeQuery();
//			rs.next();
//			
//			int id = rs.getInt("id");
//			testCust.setId(id);
//			testCust.setName("iPhone");
//			//Item editCust = new Item(testCust.getId(), testCust.getCustomerId(), testCust.getName(), testCust.getDescription(), testCust.getRent(), testCust.getAvailability());
//			idTest.updateItemById(id, false);
//			
//			sql="SELECT * FROM Item";
//			p = c.prepareStatement(sql);
//			rs = p.executeQuery();
//			
//			assertEquals(true, rs.next());
//			assertEquals(false, rs.getBoolean("isAvailable"));
//		}
//		catch (SQLException e) {
//			assertFalse(true);
//		}
//		
//		PreparedStatement p2 = null;
//		String sql2 = null;
//		ConnectionData connData = new ConnectionData();
//		Connection conn = ConnectionUtility.getConnection(connData);
//		try {
//			sql2 = "delete from Item where customerID = ?";
//			p2 = conn.prepareStatement(sql2);
//			p2.setString(1, "6");
//			p2.executeUpdate();
//		}
//		catch (SQLException e) {
//			assertFalse(true);
//		}
//		
//	}
//}
//
