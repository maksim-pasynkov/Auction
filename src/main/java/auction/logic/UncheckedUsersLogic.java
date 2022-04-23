package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.UncheckedUsersDAO;
import auction.datalayer.data.User;

public class UncheckedUsersLogic {
	
	public static List<User> getUncheckedUsers() {
		List<User> uncheckedUsers = new ArrayList<User>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			UncheckedUsersDAO uncheckedUsersDAO = factory.getUncheckedUsersDAO();
			uncheckedUsers = uncheckedUsersDAO.findUncheckedUsers();

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return uncheckedUsers;
	}

}
