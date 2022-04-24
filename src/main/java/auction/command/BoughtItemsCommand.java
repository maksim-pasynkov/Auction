package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.BoughtItemsLogic;
import auction.resource.ConfigurationManager;

public class BoughtItemsCommand implements ActionCommand {
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", BoughtItemsLogic.getBoughtItems(userId));
		page = ConfigurationManager.getProperty("path.page.user.bought.items");
		return page;
	}	

}
