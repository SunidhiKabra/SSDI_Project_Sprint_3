package unitTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dao.CustomerDao;
import dao.DAO;
import dao.ItemDao;

public class TestDAO {
	@Test
	public void returnNullValuesForDefaultConstructor(){
		DAO d = new DAO();
		assertEquals(d.getItemDAO().getClass(), ItemDao.class);
		assertEquals(d.getCustomerDAO().getClass(), CustomerDao.class);
	}
}
