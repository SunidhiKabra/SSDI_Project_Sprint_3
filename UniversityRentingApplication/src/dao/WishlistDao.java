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
import model.Wishlist;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class WishlistDao implements IWishlistDao{
	private ConnectionData conn_data = new ConnectionData();
	
	public WishlistDao()
	{
		
	}
	
	public WishlistDao(ConnectionData conn_data) {
		this.conn_data = conn_data;
	}

	@Override
	public void addItemToWishList(Wishlist wishlist) {
		Connection con = null;
		PreparedStatement statement = null;
		try {

			con = ConnectionUtility.getConnection(conn_data);
			String sql = "Insert into Wishlist (customerID, itemID) values (?,?)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, wishlist.getCustomerId());
			statement.setInt(2, wishlist.getItemId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public List<IItem> getItems(int custId) {
		// TODO Auto-generated method stub
		Connection con = null;
		List<IItem> lstItems = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);

			Statement stmt = con.createStatement();
		//	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM item where isAvailable = 1");
			PreparedStatement pstmt = con.prepareStatement("SELECT I.* , IFNULL(W.itemID, 0) AS IsWishedITem FROM item I inner join Wishlist W \n" + 
					"ON I.ID = W.ItemID AND W.CustomerID = ?\n" + 
					"where isAvailable = 1 ORDER BY I.ID");
			pstmt.setInt(1, custId);
			ResultSet rs = pstmt.executeQuery();
			lstItems = new ArrayList<IItem>();
			while (rs.next()) {
				IItem item = new Item();
				item.setId(rs.getInt("id"));
				item.setCustomerId(rs.getInt("customerID"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setRent(rs.getFloat("rent"));
//				item.setIsWishedItem((rs.getInt("IsWishListItem") != 0));
				
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
	
	public void deleteItemById(int itemId, int customerId) {
		Connection con = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("delete from Wishlist where itemID = ? and customerID = ?");

			pstmt.setInt(1, itemId);
			pstmt.setInt(2, customerId);
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

}
