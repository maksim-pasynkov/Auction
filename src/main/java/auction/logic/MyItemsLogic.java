package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.MyItemsDAO;
import auction.datalayer.data.Item;

public class MyItemsLogic {
	
	public static List<Item> getMyItems(int userId) {
		List<Item> myItems = new ArrayList<Item>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			MyItemsDAO myItemsDAO = factory.getMyItemsDAO();
			myItems = myItemsDAO.findMyItems(userId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return myItems;
	}

}
