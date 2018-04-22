package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.IItem;
import model.Item;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class ItemDao implements IItemDao {

	private ConnectionData conn_data = new ConnectionData();

	public ItemDao() {

	}

	public ItemDao(ConnectionData conn_data) {
		this.conn_data = conn_data;
	}

	@Override
	public void addItem(Item item) {
		Connection con = null;
		PreparedStatement statement = null;
		try {

			con = ConnectionUtility.getConnection(conn_data);
			String sql = "Insert into item (customerID, name, description, rent) values (?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, item.getCustomerId());
			statement.setString(2, item.getName());
			statement.setString(3, item.getDescription());
			statement.setFloat(4, item.getRent());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<IItem> getItems(int customerId) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<IItem> lstItems = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);

			Statement stmt = con.createStatement();
		//	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM item where isAvailable = 1");
			PreparedStatement pstmt = con.prepareStatement("SELECT I.*, IFNULL(W.itemId, 0) AS IsWishListItem FROM item I left join Wishlist W ON I.id = W.itemId and W.customerId = ? where isAvailable = 1");
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			lstItems = new ArrayList<IItem>();
			while (rs.next()) {
				IItem item = new Item();
				item.setId(rs.getInt("id"));
				item.setCustomerId(rs.getInt("customerID"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setRent(rs.getFloat("rent"));
				item.setIsWishedItem((rs.getInt("IsWishListItem") != 0));
				
				lstItems.add(item);
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
		return lstItems;

	}

	public List<IItem> getItemsByOwner(int customerId) {
		Connection con = null;
		List<IItem> lstItems = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM item where customerID = ?");
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			lstItems = new ArrayList<IItem>();

			while (rs.next()) {
				IItem item = new Item();
				item.setId(rs.getInt("id"));
				item.setCustomerId(rs.getInt("customerID"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setRent(rs.getFloat("rent"));
				item.setAvailability(rs.getBoolean("isAvailable"));
				lstItems.add(item);
			}
			stmt.close();

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) { /* ignore */
			}
		}
		return lstItems;
	}

	public void updateItemById(int id, boolean status) {
		Connection con = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("update item set isAvailable = ? where id = ?");

			pstmt.setBoolean(1, status);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) { /* ignore */
			}
		}
	}

	public void deleteItemById(int id) {
		Connection con = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("delete from item where id = ?");

			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) { /* ignore */
			}
		}
	}
	
	public void addCommentForItemById(int id, String comment) {
		Connection con = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			Statement stmt = con.createStatement();

			PreparedStatement pstmt = con.prepareStatement("Update item set comment= ? where id = ?");

			pstmt.setString(1, comment);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) {
			}
		}
	}
	
	public Item getItemById(int id) {
		Connection con = null;
		Item item = new Item();
		try {
			con = ConnectionUtility.getConnection(conn_data);
			Statement stmt = con.createStatement();

			PreparedStatement pstmt = con.prepareStatement("select * from item where id = ? and isAvailable=1");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				item.setId(rs.getInt("id"));
				item.setCustomerId(rs.getInt("customerID"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setRent(rs.getFloat("rent"));
				item.setComment(rs.getString("comment"));
			}
		stmt.close();

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) {
			}
		}
		return item;
	}

}
