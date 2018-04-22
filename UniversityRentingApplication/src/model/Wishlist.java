package model;

public class Wishlist implements IWishlist{
	
	private int id;
	private int itemId;
	private int customerId;

	@Override
	public void setId(int id) {
		this.id = id;
		
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
		
	}

	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public int getItemId() {
		return this.itemId;
	}

}
