package auction.datalayer;

import java.util.List;

import auction.datalayer.data.ItemCategory;

public interface ItemCategoriesDAO {
	
	List<ItemCategory> getItemCategories();

}
