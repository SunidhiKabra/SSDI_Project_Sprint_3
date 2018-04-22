package dao;

import java.util.List;

import model.*;

public interface ICustomerDao {
	public void addCustomer(Customer customer);
	public ICustomer getCustomer(String email);
	public List<Customer> getCustomers();
	public ICustomer getCustomerById(int id);
	public ICustomer setCustomerById(int id);
	public void setCustomer(Customer customer);
}
