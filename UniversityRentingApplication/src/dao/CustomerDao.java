package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.*;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class CustomerDao implements ICustomerDao {

	private ConnectionData conn_data = new ConnectionData();

	public CustomerDao(ConnectionData conn_data) {
		this.conn_data = conn_data;
	}

	public CustomerDao() {
	}

	/*
	 * public CustomerDao (ConnectionData conn_data) { this.conn_data = conn_data; }
	 */

	@Override
	public void addCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			String sql = "Insert into customer (firstName, lastName, emailID, password, phoneNumber) values (?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			statement.setString(5, customer.getPhoneNumber());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ICustomer getCustomer(String email) {
		// TODO Auto-generated method stub
		Connection con = null;
		ICustomer customer = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM customer where emailID = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
			customer = new Customer();
				
				customer.setID(rs.getInt("id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setEmail(rs.getString("emailID"));
				customer.setPhoneNumber(rs.getString("phoneNumber"));
				customer.setPassword(rs.getString("password"));
			}
			stmt.close();
			// releaseConnection(con);

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) { /* ignore */
			}
		}
		return customer;
	}

	@Override
	public ICustomer getCustomerById(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		ICustomer customer = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM customer where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
			customer = new Customer();
				
				customer.setID(rs.getInt("id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setEmail(rs.getString("emailID"));
				customer.setPhoneNumber(rs.getString("phoneNumber"));
				customer.setPassword(rs.getString("password"));
			}
			stmt.close();
			// releaseConnection(con);

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) { /* ignore */
			}
		}
		return customer;
	}
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICustomer setCustomerById(int id) {
		Connection con = null;
		ICustomer customer = null;
		
		try {
			con = ConnectionUtility.getConnection(conn_data);
			
			Statement statement = con.createStatement();
			PreparedStatement preparedStatement = con.prepareStatement("Update customer set firstName = ?, lastName = ?, emailID = ?, password = ?, phoneNumber= ? where id = " + id);
			ResultSet rs = preparedStatement.executeQuery();
			
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setString(5, customer.getPhoneNumber());
			preparedStatement.executeUpdate();
			
			statement.close();

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) { /* ignore */
			}
		}
		return customer;
	}

	@Override
	public void setCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			String sql = "Update customer set firstName = ?, lastName = ?, emailID = ?, password = ?, phoneNumber= ? where id = " + customer.getID();
			statement = con.prepareStatement(sql);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			statement.setString(5, customer.getPhoneNumber());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	

}
