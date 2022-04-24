package auction.command;

import javax.servlet.http.HttpServletRequest;

import auction.logic.SaveCheckItemsLogic;
import auction.logic.UncheckedItemsLogic;
import auction.resource.ConfigurationManager;

public class SaveCheckItemCommand implements ActionCommand {
	
	private static final String PARAM_NAME_DESCR = "descr";
	private static final String PARAM_NAME_SALE_DATE = "saleDate";
	private static final String PARAM_NAME_STEP = "step";
	private static final String PARAM_NAME_ID = "itemId";

	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String descr = request.getParameter(PARAM_NAME_DESCR);
		String saleDate = request.getParameter(PARAM_NAME_SALE_DATE);
		double step = Double.parseDouble(request.getParameter(PARAM_NAME_STEP));
		int itemId = Integer.parseInt(request.getParameter(PARAM_NAME_ID));
		SaveCheckItemsLogic.saveCheckItems(descr, saleDate, step, itemId);
		request.setAttribute("temp", UncheckedItemsLogic.getUncheckedItems());
		page = ConfigurationManager.getProperty("path.page.moderator.unchecked.items");
		return page;
	}

}
