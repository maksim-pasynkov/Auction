package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.SaveUserChangesDAO;
import auction.resource.QueryManager;

public class OracleSaveUserChangesDAO implements SaveUserChangesDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 4;
	private static final int LOGIN_INDEX = 1;
	private static final int PASSWORD_INDEX = 2;
	private static final int NAME_INDEX = 3;

	public OracleSaveUserChangesDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void saveUserChanges(int userId, String login, String pass, String name) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.update.user"));
			statement.setInt(ID_INDEX, userId);
			statement.setString(LOGIN_INDEX, login);
			statement.setString(PASSWORD_INDEX, pass);
			statement.setString(NAME_INDEX, name);
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
