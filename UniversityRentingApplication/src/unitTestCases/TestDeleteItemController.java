package unitTestCases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import api.DeleteItemController;
import dao.DAO;

public class TestDeleteItemController {
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
		DeleteItemController deleteCont = Mockito.spy(new DeleteItemController(d));
		String expectedPage = "deleteItem.do";
		assertEquals(expectedPage, deleteCont.getName());
	}
	
	@Test
	public void returnNewPageName() throws IOException, ServletException, NullPointerException{
		Mockito.when(req.getParameter("itemId")).thenReturn("30");
		DeleteItemController aic = new DeleteItemController(da);
		String expectedPage = null;
		try {
			expectedPage = aic.perform(req);
		} catch(NullPointerException e) {
			expectedPage = "myPostings.do";
		}
		assertEquals("myPostings.do", expectedPage);
	
	
	}
}