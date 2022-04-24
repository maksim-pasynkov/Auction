package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.ItemCategoriesDAO;
import auction.datalayer.data.ItemCategory;

public class ItemCategoriesLogic {
	
	public static List<ItemCategory> getItemCategories() {
		List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			ItemCategoriesDAO itemCategoriesDAO = factory.getItemCategoriesDAO();
			itemCategories = itemCategoriesDAO.getItemCategories();

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return itemCategories;
	}
}
