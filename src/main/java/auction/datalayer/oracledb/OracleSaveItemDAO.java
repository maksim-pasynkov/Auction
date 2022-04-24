package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.SaveItemDAO;
import auction.resource.QueryManager;

public class OracleSaveItemDAO implements SaveItemDAO {
	
	private Connection connection;

	private static final int DESCR_INDEX = 1;
	private static final int TYPE_INDEX = 2;
	private static final int USER_INDEX = 3;
	private static final int PRICE_INDEX = 4;
	
	public OracleSaveItemDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void saveItem(int userId, String descr, String type, double startPrice) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.insert.item"));
			statement.setString(DESCR_INDEX, descr);
			statement.setString(TYPE_INDEX, type);
			statement.setInt(USER_INDEX, userId);
			statement.setDouble(PRICE_INDEX, startPrice);
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
