package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.LogoutDAO;

public class LogoutLogic {
	
public static void deactivateUser(int userId) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			LogoutDAO logoutDAO = factory.getLogoutDAO();
			logoutDAO.deactivateUser(userId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
