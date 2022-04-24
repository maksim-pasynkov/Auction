package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.SaveCheckItemsDAO;

public class SaveCheckItemsLogic {
	
public static void saveCheckItems(String descr, String saleDate, Double step, int itemId) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			SaveCheckItemsDAO saveCheckItemsDAO = factory.getSaveCheckItemsDAO();
			saveCheckItemsDAO.saveCheckItems(descr, saleDate, step, itemId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
