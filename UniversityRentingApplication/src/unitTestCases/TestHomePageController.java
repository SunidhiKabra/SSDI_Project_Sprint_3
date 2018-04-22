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

import api.HomePageController;
import dao.DAO;

public class TestHomePageController {
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
		HomePageController hpc = Mockito.spy(new HomePageController());
		String expectedPage = "homePage.do";
		assertEquals(expectedPage, hpc.getName());
	}
	@Test
	public void returnJSPPage() {
		HomePageController hpc = Mockito.spy(new HomePageController());
		String ret = hpc.perform(req);
		String expectedPage = "homePage.jsp";
		assertEquals(expectedPage, ret);
	}
}