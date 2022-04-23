package auction.datalayer.data;

public class User {
	
	private int id;
	private String userType;
	private String login;
	private String password;
	private String name;
	private double account;
	private int blocked;
	private int active;

	public User() {

	}

	public User(int id, String userType, String login, String password,
			String name, double account, int blocked) {
		this.setId(id);
		this.setUserType(userType);
		this.setLogin(login);
		this.setPassword(password);
		this.setName(name);
		this.setAccount(account);
		this.setBlocked(blocked);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBlocked() {
		return blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.id);
		stringBuilder.append(this.userType);
		stringBuilder.append(this.login);
		stringBuilder.append(this.password);
		stringBuilder.append(this.name);
		stringBuilder.append(this.blocked);
		return stringBuilder.toString();
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
