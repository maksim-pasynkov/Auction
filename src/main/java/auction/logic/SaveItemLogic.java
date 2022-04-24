package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.SaveItemDAO;

public class SaveItemLogic {
	
public static void saveItem(int userId, String descr, String type, double startPrice) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			SaveItemDAO saveItemDAO = factory.getSaveItemDAO();
			saveItemDAO.saveItem(userId, descr, type, startPrice);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
