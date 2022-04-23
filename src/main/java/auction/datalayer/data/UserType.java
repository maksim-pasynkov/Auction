package auction.datalayer.data;

public class UserType {

	private int id;
	private String name;

	public UserType() {

	}

	public UserType(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.id);
		stringBuilder.append(this.name);
		return stringBuilder.toString();
	}

}
