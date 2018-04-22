package unitTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

import api.AddItemController;
import api.CustomerController;
import api.ItemController;
import dao.DAO;
import model.Customer;
import model.Item;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class TestItemController {
	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse resp;
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
	public void checkItem() throws ServletException, IOException, SQLException {
		Item i = new Item();
		ItemController ic = new ItemController();
		Mockito.when(req.getParameter("itemName")).thenReturn("apple");
		Mockito.when(req.getParameter("itemDescription")).thenReturn("new");
		Mockito.when(req.getParameter("itemRent")).thenReturn("50.89");
		
		ic.doGet(req,resp);
		
		String in = req.getParameter("itemName");
		String id = req.getParameter("itemDescription");
		float ir = Float.parseFloat(req.getParameter("itemRent"));
		
		i.setName(in);
		i.setDescription(id);
		i.setRent(ir);
		
		assertEquals(in, i.getName());
		assertEquals(id, i.getDescription());
		assertEquals(ir, i.getRent(),0);
		/*
		PreparedStatement p2 = null;
		String sql2 = null;
		ConnectionData connData = new ConnectionData();
		Connection conn = ConnectionUtility.getConnection(connData);
		try {
			sql2 = "delete from Item where itemRent = ?";
			System.out.println("1.");
			p2 = conn.prepareStatement(sql2);
			System.out.println("2.");
			p2.setFloat(1, i.getRent());
			System.out.println("3.");
			p2.executeUpdate();
			System.out.println("4.");
		}
		catch (SQLException e) {
			assertFalse(true);
		}*/

	}
}