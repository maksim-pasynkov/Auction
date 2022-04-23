package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.UserLogic;
import auction.resource.ConfigurationManager;

public class AllUsersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", UserLogic.getUsers(userId));
		page = ConfigurationManager.getProperty("path.page.admin.main");

		return page;
	}

}
