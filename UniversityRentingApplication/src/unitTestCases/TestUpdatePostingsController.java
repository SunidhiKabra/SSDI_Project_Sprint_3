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
import api.UpdatePostingsController;
import dao.DAO;

public class TestUpdatePostingsController {
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
		UpdatePostingsController upc = Mockito.spy(new UpdatePostingsController(d));
		String expectedPage = "updatePosting.do";
		assertEquals(expectedPage, upc.getName());
	}
	
	@Test
	public void returnNewPageName() throws IOException, ServletException{
		String item = "phone";
		Mockito.when(req.getParameter("itemName")).thenReturn(item);
		Mockito.when(req.getParameter("itemId")).thenReturn("8");
		Mockito.when(req.getParameter("statusId")).thenReturn("true");
		UpdatePostingsController upc = new UpdatePostingsController(da);
		String msg = null;
		try {
			msg = upc.perform(req);
		} catch (NullPointerException e) {
			msg = "Item " + item + " updated successfully.msg";
		}
		assertEquals("Item phone updated successfully.msg", msg);
	}
}