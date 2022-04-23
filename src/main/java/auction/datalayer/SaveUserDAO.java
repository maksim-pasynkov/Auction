package auction.datalayer;

public interface SaveUserDAO {
	
	void saveUser(int userId, int userType, String login, String pass, String name);

}
