package api;

import java.util.ArrayList;
import utilities.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dao.ItemDao;
import model.*;

public class AddItemController extends Action {

	private ItemDao itemDAO;
	private Item item;

	public AddItemController(DAO dao)
	// TODO Auto-generated constructor stub
	{
		itemDAO = dao.getItemDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "addItems.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		List<String> errors = getValidationErrors(request);
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
		} else {
			String success = null;
			HttpSession session = request.getSession(true);
			ICustomer loggedInUser = (ICustomer) session.getAttribute("loggedInUser");
			item.setCustomerId(loggedInUser.getID());
			itemDAO.addItem(item);
			success = "Item: " + item.getName() + " Added Successfully";
			request.setAttribute("message", success);
		}
		return "addItems.jsp";
	}

	public List<String> getValidationErrors(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String rent = request.getParameter("rent");

		if (name == null || name.length() == 0) {
			errors.add("Item name is required");
		}
		if (rent == null || rent.length() == 0) {
			errors.add("Item rent is required");
		} else if (!Helper.isFloat(rent)) {
			errors.add("Item rent has to be numeric");
		}

		if (errors.size() > 0)
			return errors;

		item = new Item();
		item.setName(Helper.sanitize(name));
		item.setDescription(Helper.sanitize(description));
		item.setRent(Float.parseFloat(rent));

		return errors;
	}

}
