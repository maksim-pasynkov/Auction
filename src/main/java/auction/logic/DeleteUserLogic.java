package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.DeleteUserDAO;

public class DeleteUserLogic {

	public static void deleteUser(int userId) {

		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			DeleteUserDAO deleteUserDAO = factory.getDeleteUserDAO();
			deleteUserDAO.deleteUser(userId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
