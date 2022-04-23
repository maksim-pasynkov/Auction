package auction.datalayer.data;

import java.sql.Timestamp;

public class Action {
	
	private int id;
	private int user;
	private int item;
	private Timestamp date;

	public Action() {

	}

	public Action(int id, int user, int item, Timestamp date) {
		this.setId(id);
		this.setUser(user);
		this.setItem(item);
		this.setDate(date);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.id);
		stringBuilder.append(this.user);
		stringBuilder.append(this.item);
		stringBuilder.append(this.date);
		return stringBuilder.toString();
	}

}
