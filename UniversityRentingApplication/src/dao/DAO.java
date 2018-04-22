package dao;

import utilities.ConnectionData;



public class DAO {
	private ConnectionData conn_data = new ConnectionData();
	
	private ItemDao itemDAO;
	private CustomerDao customerDao;
	private WishlistDao wishlistDao;
	
	public DAO() 
	{
		
		itemDAO = new ItemDao(conn_data); 
		customerDao = new CustomerDao(conn_data);
		wishlistDao = new WishlistDao(conn_data);

	}
	public ItemDao getItemDAO() {
		return itemDAO;
	}
	
	public CustomerDao getCustomerDAO()
	{
		return customerDao;
	}
	
	public WishlistDao getWishlistDAO()
	{
		return wishlistDao;
	}

}