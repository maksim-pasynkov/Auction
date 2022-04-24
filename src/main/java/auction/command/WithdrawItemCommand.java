package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.UncheckedItemsLogic;
import auction.logic.WithdrawItemLogic;
import auction.resource.ConfigurationManager;
import auction.resource.MessageManager;

public class WithdrawItemCommand implements ActionCommand {
	
private static final String PARAM_NAME_RADIO = "radio";
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String radioId = request.getParameter(PARAM_NAME_RADIO);
		if (radioId != null) {
			int itemId = Integer.parseInt(radioId);
			WithdrawItemLogic.withdrawItem(itemId);
		} else {
			request.setAttribute("errorMessage", MessageManager.getProperty("message.null.item"));
		}
		HttpSession session = request.getSession();
		request.setAttribute("temp", UncheckedItemsLogic.getUncheckedItems());
		page = ConfigurationManager.getProperty("path.page.moderator.unchecked.items");
		return page;
	}

}
