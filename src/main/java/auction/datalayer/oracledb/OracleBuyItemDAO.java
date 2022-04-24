package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.BuyItemDAO;
import auction.resource.QueryManager;

public class OracleBuyItemDAO implements BuyItemDAO {
	
	private Connection connection;

	private static final int USER_INDEX = 1;
	private static final int ITEM_INDEX = 2;

	public OracleBuyItemDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void buyItem(int itemId, int userId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.insert.users.action"));
			statement.setInt(USER_INDEX, userId);
			statement.setInt(ITEM_INDEX, itemId);
			statement.executeUpdate();
			statement = this.connection.prepareStatement(QueryManager.getProperty("sql.update.item.current.price"));
			statement.setInt(USER_INDEX, itemId);
			statement.setInt(ITEM_INDEX, itemId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
