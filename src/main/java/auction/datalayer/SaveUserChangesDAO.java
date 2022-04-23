package auction.datalayer;

public interface SaveUserChangesDAO {
	
	void saveUserChanges(int userId, String login, String pass, String name);

}
