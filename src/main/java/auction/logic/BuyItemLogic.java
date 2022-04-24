package auction.logic;

import auction.datalayer.BuyItemDAO;
import auction.datalayer.DAOFactory;
import auction.datalayer.DBType;
import auction.datalayer.DBTypeException;

public class BuyItemLogic {
	
public static void buyItem(int itemId, int userId) {
		
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			BuyItemDAO buyItemDAO = factory.getBuyItemDAO();
			buyItemDAO.buyItem(itemId, userId);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}

	}

}
