package auction.datalayer;

import java.util.List;

import auction.datalayer.data.User;

public interface LoginPasswordUserDAO {
	
	List<User> findUser(String login, String pass);

}
