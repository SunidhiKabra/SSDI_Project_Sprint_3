package dao;

import java.util.List;

import model.IItem;
import model.Wishlist;

public interface IWishlistDao {
	
	public void addItemToWishList(Wishlist wishlistItem);
	List<IItem> getItems(int custId);

}
