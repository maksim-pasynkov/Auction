package auction.datalayer;

import java.util.List;

import auction.datalayer.data.User;

public interface UserByIdDAO {
	
	List<User> getUser(int userId);

}
