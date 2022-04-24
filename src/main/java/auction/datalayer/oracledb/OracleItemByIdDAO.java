package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auction.datalayer.ItemByIdDAO;
import auction.datalayer.data.Item;
import auction.resource.QueryManager;

public class OracleItemByIdDAO implements ItemByIdDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;
	private static final int DESCRIPTION_INDEX = 2;
	private static final int INSTALL_DATE_INDEX = 4;
	private static final int START_PRICE_INDEX = 7;

	public OracleItemByIdDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Item> getItem(int itemId) {
		List<Item> items = new ArrayList<>();
		PreparedStatement statement = null;
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.select.item.by.id"));
			statement.setInt(ID_INDEX, itemId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Item item = new Item();
				item.setId(resultSet.getInt(ID_INDEX));
				item.setDescription(resultSet.getString(DESCRIPTION_INDEX));
				item.setStartPrice(resultSet.getDouble(START_PRICE_INDEX));
				item.setInstallDate(resultSet.getTimestamp(INSTALL_DATE_INDEX));
				items.add(item);
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
		return items;
	}

}
