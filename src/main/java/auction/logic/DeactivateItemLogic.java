package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.DeactivateItemDAO;

public class DeactivateItemLogic {
	
public static void deactivateItem(int itemId) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			DeactivateItemDAO deactivateItemDAO = factory.getDeactivateItemDAO();
			deactivateItemDAO.deactivateItem(itemId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
