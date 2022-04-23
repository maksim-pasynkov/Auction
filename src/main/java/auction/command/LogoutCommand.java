package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.LogoutLogic;
import auction.resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.index");
		// уничтожение сессии
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		LogoutLogic.deactivateUser(userId);
		request.getSession().invalidate();
		return page;
	}

}
