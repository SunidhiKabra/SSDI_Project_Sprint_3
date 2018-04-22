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
import api.ViewAccountInfoController;
import dao.DAO;

public class TestViewAccountInfoController {
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
		ViewAccountInfoController vaic = Mockito.spy(new ViewAccountInfoController(d));
		String expectedPage = "accountInfo.do";
		assertEquals(expectedPage, vaic.getName());
	}
	
	@Test
	public void returnNewPageName() throws IOException, ServletException{
		//Mockito.when(req.getParameter("name")).thenReturn("phone");
		ViewAccountInfoController vaic = new ViewAccountInfoController(da);
		String expectedPage = null;
		try {
			expectedPage = vaic.perform(req);
		}
		catch(NullPointerException e) {
			expectedPage = "accountInfo.jsp";
		}
		assertEquals("accountInfo.jsp", expectedPage);
	}
}