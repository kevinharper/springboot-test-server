package hello.model;

public class Item {
	private int itemId;
	private String description;
	//12 digit UPC-A code
	private String barcodeId;
	private double price;
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBarcodeId() {
		return barcodeId;
	}
	public void setBarcodeId(String barcodeId) {
		this.barcodeId = barcodeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
