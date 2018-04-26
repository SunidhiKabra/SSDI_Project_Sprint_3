

package api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import model.Item;

//@RequestMapping("/university/rental")
public class ItemController extends HttpServlet{
	//private ItemService item_service;
	private Item item;
	
	public ItemController() {
		
	}
	/*
	public ItemController(ItemService item_service) {
		super();
		this.item_service = item_service;
	}*/
	
	public Item createNewItem() {
		item = new Item();
		return item;
	}
	/*
	public List<Item> getItem(){
		return item_service.getItem();
	}*/
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Item i = new Item();
		ItemDao iDao = new ItemDao();
		i.setName(req.getParameter("itemName"));
		i.setDescription(req.getParameter("itemDescription"));
		i.setRent(Float.parseFloat(req.getParameter("itemRent")));
		iDao.addItem(i);
		resp.sendRedirect("homePage.jsp");
	}
}
