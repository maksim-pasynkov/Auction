package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import auction.datalayer.WithdrawItemDAO;
import auction.resource.QueryManager;

public class OracleWithdrawItemDAO implements WithdrawItemDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;

	public OracleWithdrawItemDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void withdrawItem(int itemId) {
		PreparedStatement statement = null;
		
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.withdraw.item"));
			statement.setInt(ID_INDEX, itemId);
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
