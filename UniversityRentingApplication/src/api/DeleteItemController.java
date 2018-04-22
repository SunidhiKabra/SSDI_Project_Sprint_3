package api;

import javax.servlet.http.HttpServletRequest;

import dao.DAO;
import dao.ItemDao;

public class DeleteItemController extends Action{
	
private ItemDao itemDAO;
	
	public DeleteItemController(DAO dao) {
		itemDAO = dao.getItemDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "deleteItem.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		//String success;
		itemDAO.deleteItemById(itemId);
		//success = "Item deleted successfully";
		//request.setAttribute("message", success);
		return "myPostings.do";
	}

}
