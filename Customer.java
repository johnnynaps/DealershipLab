package com.jnapolin.lab5;

public class Customer {

	private String customerId;
	private String customerName;
	private String customerCurrentVIN;

	public Customer(String currentLine) {
		String[] custArray = currentLine.split(",");
		this.customerId = custArray[0];
		this.customerName = custArray[1];
		this.customerCurrentVIN = custArray[3];
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCurrentVIN() {
		return customerCurrentVIN;
	}

	public void setCustomerCurrentVIN(String customerCurrentVIN) {
		this.customerCurrentVIN = customerCurrentVIN;
	}
}
