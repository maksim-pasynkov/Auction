package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.UserDAO;
import auction.datalayer.data.User;

public class UserLogic {
	
	public static List<User> getUsers(int userId) {
		List<User> users = new ArrayList<User>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			UserDAO userDAO = factory.getUserDAO();
			users = userDAO.getUsers(userId);

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return users;
	}

}
