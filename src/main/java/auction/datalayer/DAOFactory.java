package auction.datalayer;

public abstract class DAOFactory {
	
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}
	
	public abstract UncheckUserDAO getUncheckUserDAO();
	
	public abstract LoginPasswordUserDAO getLoginPasswordUserDAO();
	
	public abstract UserDAO getUserDAO();
	
	public abstract MaxUserIdDAO getMaxUserIdDAO();
	
	public abstract SaveUserDAO getSaveUserDAO();
	
	public abstract DeleteUserDAO getDeleteUserDAO();
	
	public abstract UserByIdDAO getUserByIdDAO();
	
	public abstract SaveUserChangesDAO getSaveUserChangesDAO();
	
	public abstract LogoutDAO getLogoutDAO();
	
	public abstract OnlineUsersDAO getOnlineUsersDAO();

	public abstract CheckUserDAO getCheckUserDAO();
	
	public abstract UserTypesDAO getUserTypesDAO();
	
	public abstract UncheckedUsersDAO getUncheckedUsersDAO();
	
	public abstract ActivateItemDAO getActivateItemDAO();
	
	public abstract ActiveItemsDAO getActiveItemsDAO();
	
	public abstract BoughtItemsDAO getBoughtItemsDAO();
	
	public abstract BuyItemDAO getBuyItemDAO();
	
	public abstract DeactivateItemDAO getDeactivateItemDAO();
	
	public abstract DeleteItemDAO getDeleteItemDAO();
	
	public abstract ItemByIdDAO getItemByIdDAO();
	
	public abstract ItemCategoriesDAO getItemCategoriesDAO();
	
	public abstract MaxItemIdDAO getMaxItemIdDAO();
	
	public abstract MyItemsDAO getMyItemsDAO();
	
	public abstract SaveCheckItemsDAO getSaveCheckItemsDAO();
	
	public abstract SaveItemChangesDAO getSaveItemChangesDAO();
	
	public abstract SaveItemDAO getSaveItemDAO();
	
	public abstract UncheckedItemsDAO getUncheckedItemsDAO();
	
	public abstract WithdrawItemDAO getWithdrawItemDAO();
}

