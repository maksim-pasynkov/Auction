package auction.datalayer;

import java.util.List;

import auction.datalayer.data.Item;

public interface ActiveItemsDAO {
	
	List<Item> findActiveItems(int userId);

}
