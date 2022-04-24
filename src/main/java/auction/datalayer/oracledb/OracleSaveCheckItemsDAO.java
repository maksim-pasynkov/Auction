package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.SaveCheckItemsDAO;
import auction.resource.QueryManager;

public class OracleSaveCheckItemsDAO implements SaveCheckItemsDAO {
	
	private Connection connection;

	private static final int SALE_DATE_INDEX = 2;
	private static final int DESCR_INDEX = 1;
	private static final int STEP_INDEX = 3;
	private static final int ID_INDEX = 4;
	private static final int ID_INDEX_NEXT = 5;

	public OracleSaveCheckItemsDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void saveCheckItems(String descr, String saleDate, Double step, int itemId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.check.item"));
			statement.setString(DESCR_INDEX, descr);
			statement.setString(SALE_DATE_INDEX, saleDate);
			statement.setDouble(STEP_INDEX, step);
			statement.setInt(ID_INDEX, itemId);
			statement.setInt(ID_INDEX_NEXT, itemId);
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
