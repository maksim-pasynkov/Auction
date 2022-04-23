package auction.logic;

import auction.datalayer.CheckUserDAO;
import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;

public class CheckUserLogic {
	
public static void checkUser(int userId) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			CheckUserDAO checkUserDAO = factory.getCheckUserDAO();
			checkUserDAO.checkUser(userId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
