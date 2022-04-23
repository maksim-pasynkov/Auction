package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.CheckUserDAO;
import auction.resource.QueryManager;

public class OracleCheckUserDAO implements CheckUserDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;

	public OracleCheckUserDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void checkUser(int userId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.check.user"));
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
