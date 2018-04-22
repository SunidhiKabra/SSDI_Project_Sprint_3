package model;

public interface ICustomer {
	public int getID();
	public String getFirstName();
	public String getLastName();
	public String getEmail();
	public String getPassword();
	public String getPhoneNumber();
	
	public void setID(int id);
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setEmail(String email);
	public void setPassword(String password);
	public void setPhoneNumber(String phoneNumber);
}
