package api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.DAO;
import model.ICustomer;

public class ViewAccountInfoController extends Action{

private CustomerDao customerDAO;
	
	public ViewAccountInfoController(DAO dao) {
		customerDAO = dao.getCustomerDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "accountInfo.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		ICustomer loggedInUser = (ICustomer) session.getAttribute("loggedInUser");
		ICustomer customer = customerDAO.getCustomerById(loggedInUser.getID()); 
		request.setAttribute("customer", customer);
		return "accountInfo.jsp";
		
		
	}
	
}
