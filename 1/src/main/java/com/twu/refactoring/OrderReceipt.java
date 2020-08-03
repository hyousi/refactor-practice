package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;
    private static final String ORDER_HEADER = "======Printing Orders======\n";
    private static final double TAX_RATE = 0.1;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		String customerName = order.getCustomerName();
		String customerAddr = order.getCustomerAddress();

		StringBuilder output = new StringBuilder();
		output.append(ORDER_HEADER);
        output.append(customerName);
        output.append(customerAddr);

		double totalSalesTax = 0d;
		double totalAmount = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.toString());

            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totalSalesTax += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t').append(totalSalesTax);
		output.append("Total Amount").append('\t').append(totalAmount);

		return output.toString();
	}
}