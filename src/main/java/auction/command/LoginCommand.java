package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.datalayer.data.User;
import auction.logic.LoginLogic;
import auction.logic.UserLogic;
import auction.resource.ConfigurationManager;
import auction.resource.MessageManager;

public class LoginCommand implements ActionCommand {

	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		// проверка логина и пароля
		User user = LoginLogic.checkLogin(login, pass);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			String userType = user.getUserType();
			if (userType.equals("Admin")) {
				request.setAttribute("user", login);
				request.setAttribute("temp", UserLogic.getUsers(user.getId()));
				page = ConfigurationManager.getProperty("path.page.admin.main");
			} else if (userType.equals("Moderator")) {
				request.setAttribute("user", login);
				page = ConfigurationManager.getProperty("path.page.moderator.main");
			} else if (userType.equals("User")) {
				if (user.getBlocked() == 1) {
					request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.blockedAccount"));
					page = ConfigurationManager.getProperty("path.page.login");
				} else {
					request.setAttribute("user", login);
					page = ConfigurationManager.getProperty("path.page.user.main");
				}
			}
		} else {
			request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}

}
