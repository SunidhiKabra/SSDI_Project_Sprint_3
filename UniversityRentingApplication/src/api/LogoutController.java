package api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutController extends Action{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "logout.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//   request.getSession().removeAttribute("loggedInUser");
		   
		  HttpSession session = request.getSession();
		  session.invalidate();
			
		return "login.do";
	}

}
