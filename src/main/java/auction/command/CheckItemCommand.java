package auction.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import auction.datalayer.data.Item;
import auction.logic.ItemByIdLogic;
import auction.logic.UncheckedItemsLogic;
import auction.resource.ConfigurationManager;
import auction.resource.MessageManager;

public class CheckItemCommand implements ActionCommand{
	
	private static final String PARAM_NAME_RADIO = "radio";
	private static final String PARAM_NAME_DESCR = "descr";
	private static final String PARAM_NAME_INSTALL_DATE = "installDate";
	private static final String PARAM_NAME_SALE_DATE = "saleDate";
	private static final String PARAM_NAME_STEP = "step";
	private static final String PARAM_NAME_ID = "itemId";

		@Override
		public String execute(HttpServletRequest request) {
			String page = null;
			String radioId = request.getParameter(PARAM_NAME_RADIO);
			if (radioId != null) {
				int itemId = Integer.parseInt(radioId);
				List<Item> items = ItemByIdLogic.getItem(itemId);
				request.setAttribute(PARAM_NAME_DESCR, items.get(0).getDescription());
				request.setAttribute(PARAM_NAME_INSTALL_DATE, items.get(0).getInstallDate());
				request.setAttribute(PARAM_NAME_SALE_DATE, items.get(0).getSaleDate());
				request.setAttribute(PARAM_NAME_STEP, items.get(0).getStep());
				request.setAttribute(PARAM_NAME_ID, items.get(0).getId());
				page = ConfigurationManager.getProperty("path.page.moderator.check.item");
			} else {
				request.setAttribute("errorMessage", MessageManager.getProperty("message.null.item"));
				request.setAttribute("temp", UncheckedItemsLogic.getUncheckedItems());
				page = ConfigurationManager.getProperty("path.page.moderator.unchecked.items");
			}
			
			return page;
		}

}
