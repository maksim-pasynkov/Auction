package auction.datalayer;

public interface SaveItemDAO {
	
	void saveItem(int userId, String descr, String type, double startPrice);

}
