package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.DeactivateItemDAO;
import auction.resource.QueryManager;

public class OracleDeactivateItemDAO implements DeactivateItemDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;

	public OracleDeactivateItemDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void deactivateItem(int itemId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.deactivate.item"));
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
