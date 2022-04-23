package auction.datalayer.data;

import java.sql.Timestamp;

public class Item {
	
	private int id;
	private String description;
	private String itemCategory;
	private Timestamp installDate;
	private Timestamp saleDate;
	private String owner;
	private double startPrice;
	private double currentPrice;
	private double step;
	private int checked;
	private int active;

	public Item() {

	}

	public Item(int id, String description, String itemCategory, Timestamp installDate,
			Timestamp saleDate, String owner, double startPrice, double currentPrice, 
			double step, int checked, int active) {
		this.setId(id);
		this.setDescription(description);
		this.setItemCategory(itemCategory);
		this.setInstallDate(installDate);
		this.setSaleDate(saleDate);
		this.setOwner(owner);
		this.setStartPrice(startPrice);
		this.setCurrentPrice(currentPrice);
		this.setStep(step);
		this.setChecked(checked);
		this.setActive(active);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Timestamp getInstallDate() {
		return installDate;
	}

	public void setInstallDate(Timestamp installDate) {
		this.installDate = installDate;
	}

	public Timestamp getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Timestamp saleDate) {
		this.saleDate = saleDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getStep() {
		return step;
	}

	public void setStep(double step) {
		this.step = step;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.id);
		stringBuilder.append(this.description);
		stringBuilder.append(this.itemCategory);
		stringBuilder.append(this.installDate);
		stringBuilder.append(this.saleDate);
		stringBuilder.append(this.owner);
		stringBuilder.append(this.startPrice);
		stringBuilder.append(this.currentPrice);
		stringBuilder.append(this.step);
		stringBuilder.append(this.checked);
		stringBuilder.append(this.active);
		return stringBuilder.toString();
	}

}
