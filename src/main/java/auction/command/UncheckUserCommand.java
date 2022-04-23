package auction.command;

import javax.servlet.http.HttpServletRequest;

import auction.logic.UncheckUserLogic;
import auction.logic.UncheckedUsersLogic;
import auction.resource.ConfigurationManager;
import auction.resource.MessageManager;

public class UncheckUserCommand implements ActionCommand {

	private static final String PARAM_NAME_RADIO = "radio";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String radioId = request.getParameter(PARAM_NAME_RADIO);
		if (radioId != null) {
			int userId = Integer.parseInt(radioId);
			UncheckUserLogic.uncheckUser(userId);
		} else {
			request.setAttribute("errorMessage", MessageManager.getProperty("message.null.user"));
		}
		request.setAttribute("temp", UncheckedUsersLogic.getUncheckedUsers());
		page = ConfigurationManager.getProperty("path.page.moderator.unchecked.users");
		return page;
	}

}
