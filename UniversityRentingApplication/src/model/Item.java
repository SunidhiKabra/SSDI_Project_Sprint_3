
package model;

public class Item implements IItem{
	
	private int id;
	private int customerId;
	private String name;
	private String description;
	private float rent;
	private boolean status;
	private String comment;
	private boolean isWishedItem;

	
	public Item()
	{
		id = -1;
		customerId = -1;
		name = null;
		description = null;
		rent = 0.0f;
		status = true;

	}
	//for testing purposes only
	public Item(int customerId, String name, String desc, float rent, boolean status)
	{
		this.id = -1;
		this.customerId = customerId;
		this.name = name;
		this.description = desc;
		this.rent = rent;
		this.status = status;
	}
	public Item(int id, int customerId, String name, String desc, float rent, boolean status)
	{
		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.description = desc;
		this.rent = rent;
		this.status = status;
	}
	
	public Item(int id, int customerId, String name, float rent)
	{
		this.id = id;
		this.customerId = customerId;
		this.name = name;
		this.rent = rent;
	}
	
	
	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void setId(int id) {
		this.id = id;
		
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
		
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setRent(float rent) {
		// TODO Auto-generated method stub
		this.rent = rent;
	}

	@Override
	public float getRent() {
		// TODO Auto-generated method stub
		return this.rent;
	}
	
	public int getItemId()
	{
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
	public void setAvailability(boolean status) {
		this.status = status;
		
	}

	@Override
	public boolean getAvailability() {
		// TODO Auto-generated method stub
		return this.status;
	}
	@Override
	public void setComment(String comment) {
		// TODO Auto-generated method stub
		this.comment= comment;
		
	}
	@Override
	public String getComment() {
		// TODO Auto-generated method stub
		return comment;
	}
	@Override
	public boolean isWishedItem() {
		// TODO Auto-generated method stub
		return this.isWishedItem;
	}
	@Override
	public void setIsWishedItem(boolean isWishedItem) {
		this.isWishedItem = isWishedItem;
		// TODO Auto-generated method stub
		
	}
	
	

}
