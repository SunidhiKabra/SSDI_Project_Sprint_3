package api;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;
import service.CustomerService;
import service.ICustomerService;

//@RequestMapping("/university/rental")
public class CustomerController extends HttpServlet {
//	private CustomerService customer_service;
	private Customer customer;
	
	public CustomerController() {}
	
//	public CustomerController(CustomerService customer_service) {
//		this.customer_service = customer_service;
//	}
	
	public Customer createNewCustomer() {
		customer = new Customer();
		return customer;
	}
	
//	public List<Customer> getCustomers(){
//		return customer_service.getCustomers();
//	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Customer cust = new Customer();
		CustomerDao custDao = new CustomerDao();
		cust.setFirstName(req.getParameter("firstName"));
		cust.setLastName(req.getParameter("lastName"));
		cust.setEmail(req.getParameter("email"));
		cust.setPassword(req.getParameter("password"));
		cust.setPhoneNumber(req.getParameter("phoneNumber"));
		custDao.addCustomer(cust);
		resp.sendRedirect("login.jsp");
	}
}
