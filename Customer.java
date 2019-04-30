package com.jnapolin.lab5;

public class Customer {

	private String customerId;
	private String customerName;
	private String customerCurrentVIN;
	private boolean customerTradeIn;
	private double customerTradeInValue;

	public Customer() {
		customerId = "";
		customerName = "";
		customerCurrentVIN = "";
		customerTradeIn = false;
		customerTradeInValue = 0.0;
	}

	public Customer(String customerName, String customerCurrentVIN, boolean customerTradeIn, double customerTradeInValue) {
		this();
		this.customerName = customerName;
		this.customerCurrentVIN = customerCurrentVIN;
		this.customerTradeIn = customerTradeIn;
		this.customerTradeInValue = customerTradeInValue;
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

	public boolean isCustomerTradeIn() {
		return customerTradeIn;
	}

	public void setCustomerTradeIn(boolean customerTradeIn) {
		this.customerTradeIn = customerTradeIn;
	}

	public double getCustomerTradeInValue() {
		return customerTradeInValue;
	}

	public void setCustomerTradeInValue(double customerTradeInValue) {
		this.customerTradeInValue = customerTradeInValue;
	}
}
