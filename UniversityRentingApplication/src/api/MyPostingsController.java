package api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dao.ItemDao;
import model.ICustomer;
import model.IItem;

public class MyPostingsController extends Action{
	private ItemDao itemDAO;
	
	public MyPostingsController(DAO dao) {
		itemDAO = dao.getItemDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "myPostings.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
		HttpSession session = request.getSession(true);
		ICustomer loggedInUser = (ICustomer) session.getAttribute("loggedInUser");
		
		List<IItem> items = itemDAO.getItemsByOwner(loggedInUser.getID());
		request.setAttribute("errors", errors);
		request.setAttribute("items", items);
		return "myPostings.jsp";
		
	}

}
