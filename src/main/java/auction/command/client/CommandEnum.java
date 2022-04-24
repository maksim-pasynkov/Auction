package auction.command.client;

import auction.command.ActionCommand;
import auction.command.ActivateItemCommand;
import auction.command.ActiveItemsCommand;
import auction.command.AddItemCommand;
import auction.command.AddUserCommand;
import auction.command.AdminMainPageCommand;
import auction.command.AllUsersCommand;
import auction.command.BoughtItemsCommand;
import auction.command.BuyItemCommand;
import auction.command.CheckItemCommand;
import auction.command.CheckUserCommand;
import auction.command.DeactivateItemCommand;
import auction.command.DeleteItemCommand;
import auction.command.DeleteUserCommand;
import auction.command.EditItemCommand;
import auction.command.EditUserCommand;
import auction.command.LoginCommand;
import auction.command.LogoutCommand;
import auction.command.ModeratorMainCommand;
import auction.command.MyItemsCommand;
import auction.command.NewItemCommand;
import auction.command.OnlineUsersCommand;
import auction.command.SaveCheckItemCommand;
import auction.command.SaveItemChangesCommand;
import auction.command.SaveItemCommand;
import auction.command.SaveUserChangesCommand;
import auction.command.SaveUserCommand;
import auction.command.UncheckUserCommand;
import auction.command.UncheckedItemsCommand;
import auction.command.UncheckedUsersCommand;
import auction.command.UserMainCommand;
import auction.command.WithdrawItemCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	LOCKUSER {
		{
			this.command = new UncheckUserCommand();
		}
	},
	UNLOCKUSER {
		{
			this.command = new CheckUserCommand();
		}
	},
	ADDUSER {
		{
			this.command = new AddUserCommand();
		}
	},
	SAVEUSER {
		{
			this.command = new SaveUserCommand();
		}
	},
	DELETEUSER {
		{
			this.command = new DeleteUserCommand();
		}
	},
	EDITUSER {
		{
			this.command = new EditUserCommand();
		}
	},
	SAVEUSERCHANGES {
		{
			this.command = new SaveUserChangesCommand();
		}
	},
	ONLINEUSERS {
		{
			this.command = new OnlineUsersCommand();
		}
	},
	ALLUSERS {
		{
			this.command = new AllUsersCommand();
		}
	},
	ADMINMAINPAGE {
		{
			this.command = new AdminMainPageCommand();
		}
	},
	USERMAINPAGE {
		{
			this.command = new UserMainCommand();
		}
	},
	MODERATORMAINPAGE {
		{
			this.command = new ModeratorMainCommand();
		}
	},
	ACTIVEITEMS {
		{
			this.command = new ActiveItemsCommand();
		}
	},
	SALECATALOGUE {
		{
			this.command = new ActiveItemsCommand();
		}
	},
	UNCHECKEDITEMS {
		{
			this.command = new UncheckedItemsCommand();
		}
	},
	WITHDRAWITEM {
		{
			this.command = new WithdrawItemCommand();
		}
	},
	CHECKITEM {
		{
			this.command = new CheckItemCommand();
		}
	},
	SAVECHECKITEM {
		{
			this.command = new SaveCheckItemCommand();
		}
	},
	MYITEMS {
		{
			this.command = new MyItemsCommand();
		}
	},
	BOUGHTITEMS {
		{
			this.command = new BoughtItemsCommand();
		}
	},
	NEWITEM {
		{
			this.command = new NewItemCommand();
		}
	},
	ADDITEM {
		{
			this.command = new AddItemCommand();
		}
	},
	SAVEITEM {
		{
			this.command = new SaveItemCommand();
		}
	},
	DELETEITEM {
		{
			this.command = new DeleteItemCommand();
		}
	}, 
	ACTIVATEITEM {
		{
			this.command = new ActivateItemCommand();
		}
	},
	PUTONSALE {
		{
			this.command = new ActivateItemCommand();
		}
	},
	DEACTIVATEITEM {
		{
			this.command = new DeactivateItemCommand();
		}
	},
	WITHDRAW {
		{
			this.command = new DeactivateItemCommand();
		}
	},
	SAVEITEMCHANGES {
		{
			this.command = new SaveItemChangesCommand();
		}
	},
	EDITITEM {
		{
			this.command = new EditItemCommand();
		}
	},
	BUYITEM {
		{
			this.command = new BuyItemCommand();
		}
	},
	UNCHECKEDUSERS {
		{
			this.command = new UncheckedUsersCommand();
		}
	},;

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}

