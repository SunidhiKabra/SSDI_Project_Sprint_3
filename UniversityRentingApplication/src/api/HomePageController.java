package api;

import javax.servlet.http.HttpServletRequest;


public class HomePageController extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "homePage.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "homePage.jsp";
	}

}
