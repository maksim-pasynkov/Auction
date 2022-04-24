package auction.logic;

import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;
import auction.datalayer.WithdrawItemDAO;

public class WithdrawItemLogic {
	
public static void withdrawItem(int itemId) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			WithdrawItemDAO withdrawItemDAO = factory.getWithdrawItemDAO();
			withdrawItemDAO.withdrawItem(itemId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
