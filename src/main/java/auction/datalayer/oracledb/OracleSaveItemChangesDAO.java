package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.SaveItemChangesDAO;
import auction.resource.QueryManager;

public class OracleSaveItemChangesDAO implements SaveItemChangesDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 3;
	private static final int DESCR_INDEX = 1;
	private static final int START_PRICE_INDEX = 2;

	public OracleSaveItemChangesDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void saveItemChanges(int itemId, String descr, double startPrice) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.update.item"));
			statement.setInt(ID_INDEX, itemId);
			statement.setString(DESCR_INDEX, descr);
			statement.setDouble(START_PRICE_INDEX, startPrice);
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
