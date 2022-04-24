package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.BoughtItemsDAO;
import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.data.Item;

public class BoughtItemsLogic {
	
	public static List<Item> getBoughtItems(int userId) {
		List<Item> boughtItems = new ArrayList<Item>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			BoughtItemsDAO boughtItemsDAO = factory.getBoughtItemsDAO();
			boughtItems = boughtItemsDAO.findBoughtItems(userId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return boughtItems;
	}

}
