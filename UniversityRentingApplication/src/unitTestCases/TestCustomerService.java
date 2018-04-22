package unitTestCases;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import dao.CustomerDao;
import model.Customer;
import service.CustomerService;

public class TestCustomerService {
	@Mock
	CustomerDao cd;
	
	@Test
	public void testItemService() {
		Customer cust = new Customer();
		CustomerService cs = Mockito.spy(new CustomerService(cd));
		cs.addCustomer(cust);
		Mockito.verify(cs).addCustomer(cust);
	}
}
