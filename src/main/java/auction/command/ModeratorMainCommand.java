package auction.command;

import javax.servlet.http.HttpServletRequest;

import auction.resource.ConfigurationManager;

public class ModeratorMainCommand implements ActionCommand{
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty("path.page.moderator.main");
		return page;
	}

}
