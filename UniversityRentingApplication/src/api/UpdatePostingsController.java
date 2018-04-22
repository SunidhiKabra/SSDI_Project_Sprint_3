package api;

import javax.servlet.http.HttpServletRequest;

import dao.DAO;
import dao.ItemDao;



public class UpdatePostingsController extends Action{
	
	private ItemDao itemDAO;
	
	public UpdatePostingsController(DAO dao) {
		itemDAO = dao.getItemDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "updatePosting.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String itemName = request.getParameter("itemName");
		int itemID =  Integer.parseInt(request.getParameter("itemId"));
		boolean statusId = Boolean.parseBoolean(request.getParameter("statusId"));
		itemDAO.updateItemById(itemID, statusId);
		return "Item " +itemName + " updated successfully.msg";
	}

}
