package auction.datalayer;

public interface SaveItemChangesDAO {
	
	void saveItemChanges(int itemId, String descr, double startPrice);

}
