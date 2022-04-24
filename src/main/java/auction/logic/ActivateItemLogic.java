package auction.logic;

import auction.datalayer.ActivateItemDAO;
import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;

public class ActivateItemLogic {
	
public static void activateItem(int itemId) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			ActivateItemDAO activateItemDAO = factory.getActivateItemDAO();
			activateItemDAO.activateItem(itemId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
