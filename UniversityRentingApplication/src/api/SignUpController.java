package api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import dao.*;
import model.*;
import utilities.Helper;

public class SignUpController extends Action{
	
	private CustomerDao customerDao;
	private Customer newUser;
	
	public SignUpController(DAO dao)
	{
		customerDao = dao.getCustomerDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "signUp.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		List<String> errors = getValidationErrors(request);
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			return "signUp.jsp";
		} else {
			String success = null;
			customerDao.addCustomer(newUser);;
			success = "User added Successfully";
			request.setAttribute("message", success);
			return "login.jsp";

		}
		
			

}
	
	
	public List<String> getValidationErrors(HttpServletRequest request){
	
		List<String> errors = new ArrayList<String>();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		
		if(firstName == null && lastName == null && email == null
				&& password == null && phoneNumber == null)
		{
			errors.add("All fields are mandatory");
			return errors;
		}
		
		
		ICustomer newCustomer = customerDao.getCustomer(email);
		
		if (firstName  == null || firstName .length() == 0) {
			errors.add("First name is required");
		}
		
		if (lastName == null || lastName.length() == 0) {
			errors.add("Last name is required");
		} 
		
		if (email  == null || email .length() == 0) {
			errors.add("Email-id is required");
		}
		else if(newCustomer != null)
		{
			errors.add("Email-id already signed up");
		}
		
		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}
		else if(password.length() < 6) {
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

		newUser = new Customer();
		newUser.setFirstName(Helper.sanitize(firstName));
		newUser.setLastName(Helper.sanitize(lastName));
		newUser.setEmail(Helper.sanitize(email));
		newUser.setPassword(Helper.sanitize(password));
		newUser.setPhoneNumber(Helper.sanitize(phoneNumber));

		return errors;
	
	}
}

