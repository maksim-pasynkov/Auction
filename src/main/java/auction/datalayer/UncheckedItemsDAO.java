package auction.datalayer;

import java.util.List;

import auction.datalayer.data.Item;

public interface UncheckedItemsDAO {
	
	List<Item> findUncheckedItems();

}
