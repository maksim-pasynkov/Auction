package auction.command;

import javax.servlet.http.HttpServletRequest;

import auction.resource.ConfigurationManager;

public class UserMainCommand implements ActionCommand{
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.user.main");
		return page;
	}

}
