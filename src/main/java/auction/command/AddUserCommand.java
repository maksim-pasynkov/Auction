package auction.command;

import javax.servlet.http.HttpServletRequest;

import auction.logic.UserTypesLogic;
import auction.resource.ConfigurationManager;

public class AddUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		request.setAttribute("temp", UserTypesLogic.getUserTypes());
		page = ConfigurationManager.getProperty("path.page.admin.add.user");
		return page;
	}

}
