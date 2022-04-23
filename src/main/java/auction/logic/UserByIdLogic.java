package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.UserByIdDAO;
import auction.datalayer.data.User;

public class UserByIdLogic {
	
	public static List<User> getUser(int userId) {
		List<User> users = new ArrayList<User>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			UserByIdDAO userByIdDAO = factory.getUserByIdDAO();
			users = userByIdDAO.getUser(userId);

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return users;
	}

}
