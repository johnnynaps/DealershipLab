package com.jnapolin.lab5;

public class Customer {

	private String customerID;
	private String customerName;

	public Customer() {
		customerID = "";
		customerName = "";
	}
	public Customer(String custID, String custName) {
		this.customerID = custID;
		this.customerName = custName;
	}
	
	public Customer(String currentLine) {
		String[] custArray = currentLine.split(",");
		this.customerID = custArray[0];
		this.customerName = custArray[1];
	}

	public String getCustomerId() {
		return customerID;
	}

	public void setCustomerId(String customerId) {
		this.customerID = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String toCSV() {
		return customerID + "," + customerName + "\r\n";
	}
}
