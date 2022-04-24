package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.DeleteItemDAO;

public class DeleteItemLogic {

	public static void deleteItem(int itemId) {

		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			DeleteItemDAO deleteItemDAO = factory.getDeleteItemDAO();
			deleteItemDAO.deleteItem(itemId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
