package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.MyItemsLogic;
import auction.logic.SaveItemChangesLogic;
import auction.resource.ConfigurationManager;

public class SaveItemChangesCommand implements ActionCommand{
	
	private static final String PARAM_NAME_INDEX = "itemId";
	private static final String PARAM_NAME_DESCR = "descr";
	private static final String PARAM_NAME_START_PRICE = "startPrice";

	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int itemId = Integer.parseInt(request.getParameter(PARAM_NAME_INDEX));
		String descr = request.getParameter(PARAM_NAME_DESCR);
		double startPrice = Double.parseDouble(request.getParameter(PARAM_NAME_START_PRICE));
		SaveItemChangesLogic.saveItemChanges(itemId, descr, startPrice);
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", MyItemsLogic.getMyItems(userId));
		page = ConfigurationManager.getProperty("path.page.user.my.items");
		return page;
	}

}
