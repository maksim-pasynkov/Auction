package auction.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import auction.datalayer.data.Item;
import auction.logic.ItemByIdLogic;
import auction.logic.MyItemsLogic;
import auction.resource.ConfigurationManager;
import auction.resource.MessageManager;

public class EditItemCommand implements ActionCommand {
	
	private static final String PARAM_NAME_ID = "itemId";
	private static final String PARAM_NAME_RADIO = "radio";
	private static final String PARAM_NAME_DESCR = "descr";
	private static final String PARAM_NAME_START_PRICE = "startPrice";

		@Override
		public String execute(HttpServletRequest request) {
			String page = null;
			String radioId = request.getParameter(PARAM_NAME_RADIO);
			if (radioId != null) {
				int itemId = Integer.parseInt(radioId);
				List<Item> items = ItemByIdLogic.getItem(itemId);
				request.setAttribute(PARAM_NAME_ID, items.get(0).getId());
				request.setAttribute(PARAM_NAME_DESCR, items.get(0).getDescription());
				request.setAttribute(PARAM_NAME_START_PRICE, items.get(0).getStartPrice());
				page = ConfigurationManager.getProperty("path.page.user.edit.item");
			} else {
				request.setAttribute("errorMessage", MessageManager.getProperty("message.null.item"));
				HttpSession session = request.getSession();
				int userId = (int) session.getAttribute("userId");
				request.setAttribute("temp", MyItemsLogic.getMyItems(userId));
				page = ConfigurationManager.getProperty("path.page.user.my.items");
			}
			
			return page;
		}

}
