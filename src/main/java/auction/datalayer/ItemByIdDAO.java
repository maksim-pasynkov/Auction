package auction.datalayer;

import java.util.List;

import auction.datalayer.data.Item;

public interface ItemByIdDAO {
	
	List<Item> getItem(int itemId);

}
