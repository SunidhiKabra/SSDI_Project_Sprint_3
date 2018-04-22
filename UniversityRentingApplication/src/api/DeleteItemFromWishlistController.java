package api;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dao.WishlistDao;
import model.ICustomer;

public class DeleteItemFromWishlistController extends Action{
private WishlistDao wishlistDao;
	
	public DeleteItemFromWishlistController(DAO dao)
	{
		wishlistDao = dao.getWishlistDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "deleteItemFromWishlist.do";
	}

	@Override
	public String perform(HttpServletRequest request) {

		int itemId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(true);
		ICustomer loggedInUser = (ICustomer) session.getAttribute("loggedInUser");
		
		int customerId= loggedInUser.getID();
		wishlistDao.deleteItemById(itemId, customerId);
		return "viewWishlist.do";	
		
	}
}
