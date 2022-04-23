package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.SaveUserDAO;
import auction.resource.QueryManager;

public class OracleSaveUserDAO implements SaveUserDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;
	private static final int USER_TYPE_INDEX = 2;
	private static final int LOGIN_INDEX = 3;
	private static final int PASSWORD_INDEX = 4;
	private static final int NAME_INDEX = 5;
	private static final int ACCOUNT_INDEX = 6;
	private static final int BLOCKED_INDEX = 7;
	
	private static final int DEFAULT_ACCOUNT = 0;
	private static final int DEFAULT_BLOCKED = 0;

	public OracleSaveUserDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void saveUser(int userId, int userType, String login, String pass, String name) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.insert.user"));
			statement.setInt(ID_INDEX, userId);
			statement.setInt(USER_TYPE_INDEX, userType);
			statement.setString(LOGIN_INDEX, login);
			statement.setString(PASSWORD_INDEX, pass);
			statement.setString(NAME_INDEX, name);
			statement.setInt(ACCOUNT_INDEX, DEFAULT_ACCOUNT);
			statement.setInt(BLOCKED_INDEX, DEFAULT_BLOCKED);
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
