package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.UncheckedItemsDAO;
import auction.datalayer.data.Item;

public class UncheckedItemsLogic {
	
	public static List<Item> getUncheckedItems() {
		List<Item> uncheckedItems = new ArrayList<Item>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			UncheckedItemsDAO uncheckedItemsDAO = factory.getUncheckedItemsDAO();
			uncheckedItems = uncheckedItemsDAO.findUncheckedItems();

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return uncheckedItems;
	}


}
