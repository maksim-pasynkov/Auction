package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auction.datalayer.ItemCategoriesDAO;
import auction.datalayer.data.ItemCategory;
import auction.resource.QueryManager;

public class OracleItemCategoriesDAO implements ItemCategoriesDAO {
	
	private Connection connection;

	private static final int ID_INDEX = 1;
	private static final int NAME_INDEX = 2;

	public OracleItemCategoriesDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<ItemCategory> getItemCategories() {
		List<ItemCategory> itemCategories = new ArrayList<>();
		PreparedStatement statement = null;
		try {
			statement = this.connection.prepareStatement(
					QueryManager.getProperty("sql.select.item.categories"));
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ItemCategory itemCategory = new ItemCategory();
				itemCategory.setId(resultSet.getInt(ID_INDEX));
				itemCategory.setName(resultSet.getString(NAME_INDEX));
				itemCategories.add(itemCategory);
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
		return itemCategories;
	}

}
