package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.ItemByIdDAO;
import auction.datalayer.data.Item;

public class ItemByIdLogic {
	
	public static List<Item> getItem(int itemId) {
		List<Item> items = new ArrayList<Item>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			ItemByIdDAO itemByIdDAO = factory.getItemByIdDAO();
			items = itemByIdDAO.getItem(itemId);

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return items;
	}

}
