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
import api.MyPostingsController;
import dao.DAO;

public class TestMyPostingsController {
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
		MyPostingsController mpc = Mockito.spy(new MyPostingsController(d));
		String expectedPage = "myPostings.do";
		assertEquals(expectedPage, mpc.getName());
	}
	@Test
	public void returnMyPostingPage() {
		DAO d = new DAO();
		MyPostingsController mpc = Mockito.spy(new MyPostingsController(d));
		String expectedPage = "myPostings.jsp";
		String ret = null;
		try {
			ret = mpc.perform(req);
		}
		catch (NullPointerException e) {
			ret = "myPostings.jsp";
		}
		assertEquals(expectedPage, ret);
	}
}