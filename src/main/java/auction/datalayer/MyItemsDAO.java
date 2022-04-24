package auction.datalayer;

import java.util.List;

import auction.datalayer.data.Item;

public interface MyItemsDAO {
	
	List<Item> findMyItems(int userId);

}
