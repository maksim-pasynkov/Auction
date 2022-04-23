package auction.resource;

import java.util.ResourceBundle;

public class MessageManager {

	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");

	// класс извлекает информацию из файла messages.properties
	private MessageManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
