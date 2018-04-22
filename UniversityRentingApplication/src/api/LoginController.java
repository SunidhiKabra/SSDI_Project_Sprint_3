package api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.*;
import model.ICustomer;

public class LoginController extends Action{
	
	private CustomerDao customerDao;
	
	public LoginController(DAO dao) {
		// TODO Auto-generated constructor stub
		
		customerDao = dao.getCustomerDAO();
	}

	@Override
	public String getName() {
		
		// TODO Auto-generated method stub
		return "login.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
		
		String email = null;
		String password = null;
		try {
			email = request.getParameter("email");
			password = request.getParameter("password");
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			email = null;
			password = null;
		}
		
		if(email == null && password == null) {
			return "login.jsp";
		}	
		
		HttpSession session = request.getSession();
		ICustomer loggedInUser = customerDao.getCustomer(email);
		if(loggedInUser == null) {	
			errors.add("No Such User Exists.");
			request.setAttribute("errors", errors);
			return "login.jsp";
		}
		else if(! password.equals(loggedInUser.getPassword())) {
			errors.add("Incorrect Password.");
			request.setAttribute("errors", errors);
			return "login.jsp";
		}
		else {
			session.setAttribute("loggedInUser",loggedInUser);
			return "homePage.do";
		}	
	}
}
