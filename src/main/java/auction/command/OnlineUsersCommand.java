package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.OnlineUsersLogic;
import auction.resource.ConfigurationManager;

public class OnlineUsersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", OnlineUsersLogic.getOnlineUsers(userId));
		page = ConfigurationManager.getProperty("path.page.admin.online.users");
		return page;
	}

}
