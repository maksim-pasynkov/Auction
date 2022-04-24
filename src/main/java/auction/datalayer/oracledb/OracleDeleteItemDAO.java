package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.DeleteItemDAO;
import auction.resource.QueryManager;

public class OracleDeleteItemDAO implements DeleteItemDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;

	public OracleDeleteItemDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void deleteItem(int itemId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.delete.item"));
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
