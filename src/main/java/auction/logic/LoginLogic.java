package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.LoginPasswordUserDAO;
import auction.datalayer.data.User;

public class LoginLogic {
	
	public static User checkLogin(String enterLogin, String enterPass) {
		List<User> users = new ArrayList<User>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			LoginPasswordUserDAO loginPasswordUserDAO = factory.getLoginPasswordUserDAO();
			users = loginPasswordUserDAO.findUser(enterLogin, enterPass);

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		if (users.size() != 0) {
			return users.get(0);
		} else {
			return null;
		}
		
	}

}
