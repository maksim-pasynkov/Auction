package auction.datalayer;

import java.util.List;

import auction.datalayer.data.User;

public interface OnlineUsersDAO {
	
	List<User> getOnlineUsers(int userId);

}
