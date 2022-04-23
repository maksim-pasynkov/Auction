package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.SaveUserChangesDAO;

public class SaveUserChangesLogic {
	
public static void saveUserChanges(int userId, String login, String pass, String name) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			SaveUserChangesDAO saveUserChangesDAO = factory.getSaveUserChangesDAO();
			saveUserChangesDAO.saveUserChanges(userId, login, pass, name);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
