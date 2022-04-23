package auction.command.factory;

import javax.servlet.http.HttpServletRequest;

import auction.command.ActionCommand;
import auction.command.EmptyCommand;
import auction.command.client.CommandEnum;
import auction.resource.MessageManager;

public class ActionFactory {
	
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		// ���������� ����� ������� �� �������
		String action = request.getParameter("command");
		System.out.println(action);
		if (action == null || action.isEmpty()) {
			// ���� ������� �� ������ � ������� �������
			return current;
		}
		// ��������� �������, ���������������� �������
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.replaceAll(" ","").toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}

}
