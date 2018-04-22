package api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.WishlistDao;
import model.ICustomer;
import model.IItem;
import dao.DAO;

public class ViewWishlistController extends Action
{
	private WishlistDao wishlistDao;
	
	public ViewWishlistController(DAO dao)
	{
		wishlistDao = dao.getWishlistDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "viewWishlist.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
		HttpSession session = request.getSession(true);
		ICustomer loggedInUser = (ICustomer) session.getAttribute("loggedInUser");
		List<IItem> items = wishlistDao.getItems(loggedInUser.getID());
		request.setAttribute("errors", errors);
		request.setAttribute("items", items);	
		return "wishlist.jsp";
	}

}
