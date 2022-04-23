package auction.command.client;

import auction.command.ActionCommand;
import auction.command.AddUserCommand;
import auction.command.AdminMainPageCommand;
import auction.command.AllUsersCommand;
import auction.command.CheckUserCommand;
import auction.command.DeleteUserCommand;
import auction.command.EditUserCommand;
import auction.command.LoginCommand;
import auction.command.LogoutCommand;
import auction.command.OnlineUsersCommand;
import auction.command.SaveUserChangesCommand;
import auction.command.SaveUserCommand;
import auction.command.UncheckUserCommand;

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
	}
	;

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}

