package auction.command;

import javax.servlet.http.HttpServletRequest;

import auction.logic.UncheckedUsersLogic;
import auction.resource.ConfigurationManager;

public class UncheckedUsersCommand implements ActionCommand{
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		request.setAttribute("temp", UncheckedUsersLogic.getUncheckedUsers());
		page = ConfigurationManager.getProperty("path.page.moderator.unchecked.users");
		return page;
	}

}
