package api;

import java.util.ArrayList;

import java.util.List;
import utilities.*;
import javax.servlet.http.HttpServletRequest;

import dao.*;
import model.*;

public class ViewRenterController extends Action {

	private CustomerDao customerDAO;

	public ViewRenterController(DAO dao) {
		this.customerDAO = dao.getCustomerDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "viewRenter.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub

		String strCustomerId = request.getParameter("customerId");
		List<String> errors = new ArrayList<String>();

		if(!Helper.isInteger(strCustomerId)) {
			errors.add("Invalid Renter. Please re-try");
			request.setAttribute("errors", errors);
			return "viewItems.jsp";
		}
		
		ICustomer renter = customerDAO.getCustomerById(Integer.parseInt(strCustomerId));
		if (renter == null) {
			
			errors.add("Invalid Renter. Please re-try");
			request.setAttribute("errors", errors);
			return "viewItems.jsp";
		}
		
		request.setAttribute("renter", renter);

		return "viewRenter.jsp";

	}

}
