package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.UserLogic;
import auction.resource.ConfigurationManager;

public class AdminMainPageCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", UserLogic.getUsers(userId));
		String page = ConfigurationManager.getProperty("path.page.admin.main");
		return page;
	}

}
