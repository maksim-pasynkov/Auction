package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import auction.datalayer.MaxItemIdDAO;
import auction.resource.QueryManager;

public class OracleMaxItemIdDAO implements MaxItemIdDAO {
	
	private Connection connection;
	
	public OracleMaxItemIdDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public int getMaxItemId() {
		PreparedStatement statement = null;
		int itemId=0;
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.select.max.id.item"));
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				itemId = resultSet.getInt(1);
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
		
		return itemId;
	}

}
