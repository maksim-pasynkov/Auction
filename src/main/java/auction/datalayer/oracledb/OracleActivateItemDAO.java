package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.ActivateItemDAO;
import auction.resource.QueryManager;

public class OracleActivateItemDAO implements ActivateItemDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;

	public OracleActivateItemDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void activateItem(int itemId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.activate.item"));
			statement.setInt(ID_INDEX, itemId);
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
