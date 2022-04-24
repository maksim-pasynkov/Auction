package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.ActiveItemsLogic;
import auction.logic.BuyItemLogic;
import auction.resource.ConfigurationManager;

public class BuyItemCommand implements ActionCommand{
	
	private static final String PARAM_NAME_INDEX = "itemId";

	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int itemId = Integer.parseInt(request.getParameter(PARAM_NAME_INDEX));
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		BuyItemLogic.buyItem(itemId, userId);
		request.setAttribute("temp", ActiveItemsLogic.getActiveItems(userId));
		page = ConfigurationManager.getProperty("path.page.user.active.items");
		return page;
	}

}
