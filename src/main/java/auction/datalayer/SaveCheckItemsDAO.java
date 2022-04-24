package auction.datalayer;

public interface SaveCheckItemsDAO {
	
	void saveCheckItems(String descr, String saleDate, Double step, int itemId);

}
