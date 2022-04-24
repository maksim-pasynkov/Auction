package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auction.datalayer.BoughtItemsDAO;
import auction.datalayer.data.Item;
import auction.resource.QueryManager;

public class OracleBoughtItemsDAO implements BoughtItemsDAO {

	private Connection connection;

	private static final int ID_INDEX = 1;
	private static final int DESCRIPTION_INDEX = 2;
	private static final int CATEGORY_INDEX = 3;
	private static final int INSTALL_DATE_INDEX = 4;
	private static final int SALE_DATE_INDEX = 5;
	private static final int OWNER_INDEX = 6;
	private static final int START_PRICE_INDEX = 7;
	private static final int CURRENT_PRICE_INDEX = 8;
	private static final int STEP_INDEX = 9;
	private static final int CHECKED_INDEX = 10;
	private static final int ACTIVE_INDEX = 11;

	public OracleBoughtItemsDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Item> findBoughtItems(int userId) {
		List<Item> myItems = new ArrayList<>();
		PreparedStatement statement = null;
		try {
			statement = this.connection.prepareStatement(QueryManager.getProperty("sql.select.bought.items"));
			statement.setInt(ID_INDEX, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Item item = new Item();
				item.setId(resultSet.getInt(ID_INDEX));
				item.setDescription(resultSet.getString(DESCRIPTION_INDEX));
				item.setItemCategory(resultSet.getString(CATEGORY_INDEX));
				item.setInstallDate(resultSet.getTimestamp(INSTALL_DATE_INDEX));
				item.setSaleDate(resultSet.getTimestamp(SALE_DATE_INDEX));
				item.setOwner(resultSet.getString(OWNER_INDEX));
				item.setStartPrice(resultSet.getDouble(START_PRICE_INDEX));
				item.setCurrentPrice(resultSet.getDouble(CURRENT_PRICE_INDEX));
				item.setStep(resultSet.getDouble(STEP_INDEX));
				item.setChecked(resultSet.getInt(CHECKED_INDEX));
				item.setActive(resultSet.getInt(ACTIVE_INDEX));
				myItems.add(item);
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
		return myItems;
	}

}
