package auction.datalayer;

import java.util.List;

import auction.datalayer.data.Item;

public interface BoughtItemsDAO {
	
	List<Item> findBoughtItems(int userId);

}
