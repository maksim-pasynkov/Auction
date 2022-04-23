package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.SaveUserLogic;
import auction.logic.UserLogic;
import auction.resource.ConfigurationManager;

public class SaveUserCommand implements ActionCommand {
	
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_TYPE = "user_type";
	private static final String PARAM_NAME_FULL_NAME = "full_name";
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		int userType = Integer.parseInt(request.getParameter(PARAM_NAME_TYPE));
		String name = request.getParameter(PARAM_NAME_FULL_NAME);
		// проверка логина и пароля
		SaveUserLogic.saveUser(userType, login, pass, name);
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", UserLogic.getUsers(userId));
		page = ConfigurationManager.getProperty("path.page.admin.main");
		return page;
	}

}
