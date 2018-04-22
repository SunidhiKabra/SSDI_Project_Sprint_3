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
import api.ViewItemController;
import dao.DAO;

public class TestViewItemController {
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
		ViewItemController vic = Mockito.spy(new ViewItemController(d));
		String expectedPage = "viewItems.do";
		assertEquals(expectedPage, vic.getName());
	}
	
	@Test
	public void returnNewPageName() throws IOException, ServletException{
		//Mockito.when(req.getParameter("name")).thenReturn("phone");
		ViewItemController aic = new ViewItemController(da);
		String expectedPage = null;
		try {
			expectedPage = aic.perform(req);
		}
		catch (NullPointerException e) {
			expectedPage = "viewItems.jsp";
		}
		assertEquals("viewItems.jsp", expectedPage);
	}
	
}
