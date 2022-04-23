package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.DeleteUserDAO;
import auction.resource.QueryManager;

public class OracleDeleteUserDAO implements DeleteUserDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;

	public OracleDeleteUserDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void deleteUser(int userId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.delete.user"));
			statement.setInt(ID_INDEX, userId);
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

