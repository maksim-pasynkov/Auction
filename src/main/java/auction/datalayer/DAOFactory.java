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
}

