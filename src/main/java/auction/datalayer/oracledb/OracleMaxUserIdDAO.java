package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import auction.datalayer.MaxUserIdDAO;
import auction.resource.QueryManager;

public class OracleMaxUserIdDAO implements MaxUserIdDAO {
	
	private Connection connection;
	
	public OracleMaxUserIdDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public int getMaxUserId() {
		PreparedStatement statement = null;
		int userId=0;
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.select.max.id.user"));
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userId = resultSet.getInt(1);
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
		
		return userId;
	}

}
