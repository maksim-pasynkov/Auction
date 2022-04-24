package auction.command;

import javax.servlet.http.HttpServletRequest;

import auction.logic.ItemCategoriesLogic;
import auction.resource.ConfigurationManager;

public class AddItemCommand implements ActionCommand{

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		request.setAttribute("temp", ItemCategoriesLogic.getItemCategories());
		page = ConfigurationManager.getProperty("path.page.user.add.item");
		return page;
	}

}
