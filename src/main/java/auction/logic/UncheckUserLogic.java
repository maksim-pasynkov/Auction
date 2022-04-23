package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.UncheckUserDAO;

public class UncheckUserLogic {
	
public static void uncheckUser(int userId) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			UncheckUserDAO uncheckUserDAO = factory.getUncheckUserDAO();
			uncheckUserDAO.uncheckUser(userId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
