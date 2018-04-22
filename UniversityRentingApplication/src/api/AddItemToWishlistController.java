package api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dao.WishlistDao;
import model.ICustomer;
import model.Wishlist;

public class AddItemToWishlistController extends Action{
	
	private WishlistDao wishlistDao;
	private Wishlist wishlist;
	
	public AddItemToWishlistController(DAO dao)
	{
		wishlistDao = dao.getWishlistDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "addToWishList.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		List<String> errors = new ArrayList<String>();
//		String success = null;
		HttpSession session = request.getSession(true);
		ICustomer loggedInUser = (ICustomer) session.getAttribute("loggedInUser");
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		wishlist = new Wishlist();
		wishlist.setCustomerId(loggedInUser.getID());
		wishlist.setItemId(itemId);
		wishlistDao.addItemToWishList(wishlist);
		request.setAttribute("errors", errors);
//		success = "Item Added To Wishlist";
//		request.setAttribute("message", success);
		return "Item Added To Wishlist.msg";
	}

}
