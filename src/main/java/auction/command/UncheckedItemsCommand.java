package auction.command;

import javax.servlet.http.HttpServletRequest;

import auction.logic.UncheckedItemsLogic;
import auction.resource.ConfigurationManager;

public class UncheckedItemsCommand implements ActionCommand {
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		request.setAttribute("temp", UncheckedItemsLogic.getUncheckedItems());
		page = ConfigurationManager.getProperty("path.page.moderator.unchecked.items");
		return page;
	}

}
