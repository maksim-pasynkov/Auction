package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.LogoutDAO;
import auction.resource.QueryManager;

public class OracleLogoutDAO implements LogoutDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;

	public OracleLogoutDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void deactivateUser(int userId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.update.deactive.user"));
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
