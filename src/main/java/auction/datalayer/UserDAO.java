package auction.datalayer;

import java.util.List;

import auction.datalayer.data.User;

public interface UserDAO {
	
	List<User> getUsers(int userId);

}
