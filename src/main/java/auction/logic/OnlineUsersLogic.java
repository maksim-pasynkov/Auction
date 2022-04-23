package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.OnlineUsersDAO;
import auction.datalayer.data.User;

public class OnlineUsersLogic {
	
	public static List<User> getOnlineUsers(int userId) {
		List<User> users = new ArrayList<User>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			OnlineUsersDAO onlineUsersDAO = factory.getOnlineUsersDAO();
			users = onlineUsersDAO.getOnlineUsers(userId);

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return users;
	}

}
