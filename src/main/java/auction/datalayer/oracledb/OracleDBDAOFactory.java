package auction.datalayer.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import auction.datalayer.CheckUserDAO;
import auction.datalayer.DAOFactory;
import auction.datalayer.DeleteUserDAO;
import auction.datalayer.LoginPasswordUserDAO;
import auction.datalayer.LogoutDAO;
import auction.datalayer.MaxUserIdDAO;
import auction.datalayer.OnlineUsersDAO;
import auction.datalayer.SaveUserChangesDAO;
import auction.datalayer.SaveUserDAO;
import auction.datalayer.UncheckUserDAO;
import auction.datalayer.UncheckedUsersDAO;
import auction.datalayer.UserByIdDAO;
import auction.datalayer.UserDAO;
import auction.datalayer.UserTypesDAO;

public class OracleDBDAOFactory extends DAOFactory {
	
	private static volatile OracleDBDAOFactory instance;
	private Connection connection;

	private OracleDBDAOFactory() {
	}

	public static OracleDBDAOFactory getInstance()
			throws ClassNotFoundException, SQLException {
		OracleDBDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDBDAOFactory.class) {
				instance = factory = new OracleDBDAOFactory();
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException {
		Locale.setDefault(Locale.ENGLISH);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "system";
		String password = "12345";
		connection = DriverManager.getConnection(url, user, password);
		if (connection != null)
			System.out.println("Connected to oracle DB!");
	}

	@Override
	public LoginPasswordUserDAO getLoginPasswordUserDAO() {
		return new OracleLoginPasswordUserDAO(connection);
	}
	
	@Override
	public UserDAO getUserDAO() {
		return new OracleUserDAO(connection);
	}
	
	@Override
	public MaxUserIdDAO getMaxUserIdDAO() {
		return new OracleMaxUserIdDAO(connection);
	}
	
	@Override
	public SaveUserDAO getSaveUserDAO() {
		return new OracleSaveUserDAO(connection);
	}
	
	@Override
	public DeleteUserDAO getDeleteUserDAO() {
		return new OracleDeleteUserDAO(connection);
	}
	
	@Override
	public UserByIdDAO getUserByIdDAO() {
		return new OracleUserByIdDAO(connection);
	}
	
	@Override
	public SaveUserChangesDAO getSaveUserChangesDAO() {
		return new OracleSaveUserChangesDAO(connection);
	}
	
	@Override 
	public LogoutDAO getLogoutDAO() {
		return new OracleLogoutDAO(connection);
	}
	
	@Override
	public OnlineUsersDAO getOnlineUsersDAO() {
		return new OracleOnlineUsersDAO(connection);
	}

	@Override
	public CheckUserDAO getCheckUserDAO() {
		return new OracleCheckUserDAO(connection);
	}

	@Override
	public UncheckUserDAO getUncheckUserDAO() {
		return new OracleUncheckUserDAO(connection);
	}
	
	@Override
	public UserTypesDAO getUserTypesDAO() {
		return new OracleUserTypesDAO(connection);
	}
	
	@Override
	public UncheckedUsersDAO getUncheckedUsersDAO() {
		return new OracleUncheckedUsersDAO(connection);
	}


}
