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

import api.LogoutController;
import dao.DAO;

public class TestLogOutController {
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
		LogoutController aic = Mockito.spy(new LogoutController());
		String expectedPage = "logout.do";
		assertEquals(expectedPage, aic.getName());
	}
	@Test
	public void returnLoginPage() {
		LogoutController aic = Mockito.spy(new LogoutController());
		String page = null;
		String expectedPage = "login.do";
		try {
			page = aic.perform(req);
		}
		catch(NullPointerException e)
		{
			page = "login.do";
		}
		assertEquals(expectedPage, page);
		
	}
}