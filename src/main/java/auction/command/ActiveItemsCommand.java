package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.ActiveItemsLogic;
import auction.resource.ConfigurationManager;

public class ActiveItemsCommand implements ActionCommand{
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", ActiveItemsLogic.getActiveItems(userId));
		page = ConfigurationManager.getProperty("path.page.user.active.items");
		return page;
	}

}
