package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.MyItemsLogic;
import auction.resource.ConfigurationManager;

public class MyItemsCommand implements ActionCommand {
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", MyItemsLogic.getMyItems(userId));
		page = ConfigurationManager.getProperty("path.page.user.my.items");
		return page;
	}

}
