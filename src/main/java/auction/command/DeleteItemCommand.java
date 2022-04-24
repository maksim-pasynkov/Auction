package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.DeleteItemLogic;
import auction.logic.MyItemsLogic;
import auction.resource.ConfigurationManager;
import auction.resource.MessageManager;

public class DeleteItemCommand implements ActionCommand {
	
private static final String PARAM_NAME_RADIO = "radio";
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String radioId = request.getParameter(PARAM_NAME_RADIO);
		if (radioId != null) {
			int itemId = Integer.parseInt(radioId);
			DeleteItemLogic.deleteItem(itemId);
		} else {
			request.setAttribute("errorMessage", MessageManager.getProperty("message.null.item"));
		}
		HttpSession session = request.getSession();
		request.setAttribute("temp", MyItemsLogic.getMyItems((int) session.getAttribute("userId")));
		page = ConfigurationManager.getProperty("path.page.user.my.items");
		return page;
	}

}
