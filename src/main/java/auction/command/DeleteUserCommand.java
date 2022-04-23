package auction.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.logic.DeleteUserLogic;
import auction.logic.UserLogic;
import auction.resource.ConfigurationManager;
import auction.resource.MessageManager;

public class DeleteUserCommand implements ActionCommand {
	
private static final String PARAM_NAME_RADIO = "radio";
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String radioId = request.getParameter(PARAM_NAME_RADIO);
		if (radioId != null) {
			int userId = Integer.parseInt(radioId);
			DeleteUserLogic.deleteUser(userId);
		} else {
			request.setAttribute("errorMessage", MessageManager.getProperty("message.null.user"));
		}
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		request.setAttribute("temp", UserLogic.getUsers(userId));
		page = ConfigurationManager.getProperty("path.page.admin.main");
		
		return page;
	}

}
