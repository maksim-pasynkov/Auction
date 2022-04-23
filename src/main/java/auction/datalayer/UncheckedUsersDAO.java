package auction.datalayer;

import java.util.List;

import auction.datalayer.data.User;

public interface UncheckedUsersDAO {
	
	List<User> findUncheckedUsers();

}
