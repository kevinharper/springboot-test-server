package hello.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private int orderId;
	private int customerId;
	private String internalOrderNumber;
	private List<Item> items = new ArrayList<Item>();
	private double tax;
	private double discount;
	private String discountType;
	private double totalPrice;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getInternalOrderNumber() {
		return internalOrderNumber;
	}
	public void setInternalOrderNumber(String internalOrderNumber) {
		this.internalOrderNumber = internalOrderNumber;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
