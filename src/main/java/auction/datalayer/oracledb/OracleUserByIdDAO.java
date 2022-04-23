package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auction.datalayer.UserByIdDAO;
import auction.datalayer.data.User;
import auction.resource.QueryManager;

public class OracleUserByIdDAO implements UserByIdDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;
	private static final int USER_TYPE_INDEX = 2;
	private static final int LOGIN_INDEX = 3;
	private static final int PASSWORD_INDEX = 4;
	private static final int NAME_INDEX = 5;
	private static final int ACCOUNT_INDEX = 6;
	private static final int BLOCKED_INDEX = 7;

	public OracleUserByIdDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<User> getUser(int userId) {
		List<User> users = new ArrayList<>();
		PreparedStatement statement = null;
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.select.user.by.id"));
			statement.setInt(ID_INDEX, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(ID_INDEX));
				user.setUserType(resultSet.getString(USER_TYPE_INDEX));
				user.setLogin(resultSet.getString(LOGIN_INDEX));
				user.setPassword(resultSet.getString(PASSWORD_INDEX));
				user.setName(resultSet.getString(NAME_INDEX));
				user.setAccount(resultSet.getDouble(ACCOUNT_INDEX));
				user.setBlocked(resultSet.getInt(BLOCKED_INDEX));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

}
