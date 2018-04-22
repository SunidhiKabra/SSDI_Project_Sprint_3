package api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.DAO;
import model.Customer;
import model.ICustomer;
import utilities.Helper;

public class EditInformationController extends Action {
private CustomerDao customerDao;

	
	public EditInformationController(DAO dao) {
		customerDao = dao.getCustomerDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "editInfo.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
		//customerDao.setCustomer(loggedInUser);
		
		List<String> errors = getValidationErrors(request, loggedInUser);
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			return "editInfo.jsp";
		} else {
			String success = null;
			customerDao.setCustomer(loggedInUser);
			success = "Information Updated Successfully";
			request.setAttribute("message", success);
			return "accountInfo.do";
		}
	}
		
	
		public List<String> getValidationErrors(HttpServletRequest request, Customer loggedInUser){
			
			List<String> errors = new ArrayList<String>();
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			
			
			if(password.length() < 6) {
				errors.add("Password should be minimum 6 characters");
			}
		
			if (phoneNumber == null || phoneNumber.length() == 0) {
				errors.add("Phone number is required");
			}
			else if (!Helper.isLong(phoneNumber)) {
				errors.add("Phone number has to be numeric. No hypens/brackets");
			}
			
			if (errors.size() > 0)
				return errors;
			
			loggedInUser.setFirstName(Helper.sanitize(firstName));
			loggedInUser.setLastName(Helper.sanitize(lastName));
			loggedInUser.setEmail(Helper.sanitize(email));
			loggedInUser.setPassword(Helper.sanitize(password));
			loggedInUser.setPhoneNumber(Helper.sanitize(phoneNumber));

			return errors;
		
		}
}
