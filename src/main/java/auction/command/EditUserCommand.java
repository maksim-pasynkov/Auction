package auction.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.datalayer.data.User;
import auction.logic.UserByIdLogic;
import auction.logic.UserLogic;
import auction.resource.ConfigurationManager;
import auction.resource.MessageManager;

public class EditUserCommand implements ActionCommand {

	private static final String PARAM_NAME_ID = "userId";
	private static final String PARAM_NAME_RADIO = "radio";
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_NAME_TYPE = "userType";
	private static final String PARAM_NAME_FULL_NAME = "name";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String radioId = request.getParameter(PARAM_NAME_RADIO);
		if (radioId != null) {
			int userId = Integer.parseInt(radioId);
			List<User> users = UserByIdLogic.getUser(userId);
			request.setAttribute(PARAM_NAME_ID, users.get(0).getId());
			request.setAttribute(PARAM_NAME_LOGIN, users.get(0).getLogin());
			request.setAttribute(PARAM_NAME_PASSWORD, users.get(0).getPassword());
			request.setAttribute(PARAM_NAME_TYPE, users.get(0).getUserType());
			request.setAttribute(PARAM_NAME_FULL_NAME, users.get(0).getName());
			page = ConfigurationManager.getProperty("path.page.admin.edit.user");
		} else {
			request.setAttribute("errorMessage", MessageManager.getProperty("message.null.user"));
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userId");
			request.setAttribute("temp", UserLogic.getUsers(userId));
			page = ConfigurationManager.getProperty("path.page.admin.main");
		}

		return page;
	}

}
