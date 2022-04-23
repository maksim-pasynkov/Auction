package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.UncheckUserDAO;
import auction.resource.QueryManager;

public class OracleUncheckUserDAO implements UncheckUserDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;

	public OracleUncheckUserDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void uncheckUser(int userId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.uncheck.user"));
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
