
package model;

public interface IItem {
	public void setId(int id);
	public int getId();
	
	public void setName(String name);
	public String getName();
	
	public void setDescription(String description);
	public String getDescription();
	
	public void setRent(float rent);
	public float getRent();
	
	public void setCustomerId(int customerId);
	public int getCustomerId();
	
	public void setAvailability(boolean status);
	public boolean getAvailability();
	
	public void setComment(String comment);
	public String getComment();
	
	public void setIsWishedItem(boolean isWishedItem);
	public boolean isWishedItem();

}