package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.MyItemsLogic;
import auction.logic.SaveItemLogic;
import auction.resource.ConfigurationManager;

public class SaveItemCommand implements ActionCommand {
	
	private static final String PARAM_NAME_DESCRIPTION = "description";
	private static final String PARAM_NAME_TYPE = "type";
	private static final String PARAM_NAME_START_PRICE = "startPrice";
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String descr = request.getParameter(PARAM_NAME_DESCRIPTION);
		String type = request.getParameter(PARAM_NAME_TYPE);
		double startPrice = Double.parseDouble(request.getParameter(PARAM_NAME_START_PRICE));
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		SaveItemLogic.saveItem(userId, descr, type, startPrice);
		request.setAttribute("temp", MyItemsLogic.getMyItems(userId));
		page = ConfigurationManager.getProperty("path.page.user.my.items");
		return page;
	}

}
