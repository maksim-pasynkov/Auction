package auction.logic;

import java.util.ArrayList;
import java.util.List;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.UserTypesDAO;
import auction.datalayer.data.UserType;

public class UserTypesLogic {
	
	public static List<UserType> getUserTypes() {
		List<UserType> userTypes = new ArrayList<UserType>();
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			UserTypesDAO userTypesDAO = factory.getUserTypesDAO();
			userTypes = userTypesDAO.getUserTypes();

		} catch (DBTypeException e) {
			e.printStackTrace();
		}
		return userTypes;
	}

}
