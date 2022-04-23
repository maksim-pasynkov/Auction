package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auction.datalayer.UserTypesDAO;
import auction.datalayer.data.UserType;
import auction.resource.QueryManager;

public class OracleUserTypesDAO implements UserTypesDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;
	private static final int NAME_INDEX = 2;
	
	public OracleUserTypesDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<UserType> getUserTypes() {
		List<UserType> userTypes = new ArrayList<>();
		PreparedStatement statement = null;
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.select.user.types"));
			System.out.println(statement.getFetchSize()); 
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserType userType = new UserType();
				userType.setId(resultSet.getInt(ID_INDEX));
				userType.setName(resultSet.getString(NAME_INDEX));
				userTypes.add(userType);
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
		return userTypes;
	}

}
