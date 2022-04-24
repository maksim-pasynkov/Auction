package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.SaveItemChangesDAO;

public class SaveItemChangesLogic {
	
public static void saveItemChanges(int itemId, String descr, double startPrice) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			SaveItemChangesDAO saveItemChangesDAO = factory.getSaveItemChangesDAO();
			saveItemChangesDAO.saveItemChanges(itemId, descr, startPrice);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
