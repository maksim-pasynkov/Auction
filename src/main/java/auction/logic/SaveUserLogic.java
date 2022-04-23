package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.MaxUserIdDAO;
import auction.datalayer.SaveUserDAO;

public class SaveUserLogic {
	
public static void saveUser(int userType, String login, String pass, String name) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			MaxUserIdDAO maxUserIdDAO = factory.getMaxUserIdDAO();
			int userId = maxUserIdDAO.getMaxUserId();
			
			DAOFactory factory1 = DAOFactory.getInstance(DBType.ORACLE);
			SaveUserDAO saveUserDAO = factory1.getSaveUserDAO();
			saveUserDAO.saveUser(userId+1, userType, login, pass, name);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
