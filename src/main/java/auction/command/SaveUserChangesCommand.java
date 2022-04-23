package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.SaveUserChangesLogic;
import auction.logic.UserLogic;
import auction.resource.ConfigurationManager;

public class SaveUserChangesCommand implements ActionCommand {

	private static final String PARAM_NAME_INDEX = "userId";
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_TYPE = "userType";
	private static final String PARAM_NAME_FULL_NAME = "name";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из запроса логина и пароля
		int userId = Integer.parseInt(request.getParameter(PARAM_NAME_INDEX));
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String name = request.getParameter(PARAM_NAME_FULL_NAME);
		// проверка логина и пароля
		SaveUserChangesLogic.saveUserChanges(userId, login, pass, name);
		HttpSession session = request.getSession();
		userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", UserLogic.getUsers(userId));
		page = ConfigurationManager.getProperty("path.page.admin.main");
		return page;
	}

}
