package com.twu.refactoring;

public class LineItem {
	private String desc;
	private double price;
	private int quantity;

	public LineItem(String desc, double price, int quantity) {
		super();
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\n", desc, price, quantity, totalAmount());
	}
}