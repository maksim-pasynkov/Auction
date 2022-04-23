package auction.resource;

import java.util.ResourceBundle;

public class QueryManager {

	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.query");

	// ����� ��������� ���������� �� ����� messages.properties
	private QueryManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
