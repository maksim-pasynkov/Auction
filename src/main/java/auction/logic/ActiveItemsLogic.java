package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.ActiveItemsDAO;
import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.data.Item;

public class ActiveItemsLogic {
	
	public static List<Item> getActiveItems(int userId) {
		List<Item> activeItems = new ArrayList<Item>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			ActiveItemsDAO activeItemsDAO = factory.getActiveItemsDAO();
			activeItems = activeItemsDAO.findActiveItems(userId);

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return activeItems;
	}

}
