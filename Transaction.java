package com.jnapolin.lab5;

public class Transaction {

	private String transactionDate;
	private String transactionTime;
	private SalesAssociate transactionSalesAssociate;
	private Customer transactionCustomer;
	private Car transactionCar;
	private double transactionTotal;

	public Transaction() {
		transactionDate = "";
		transactionTime = "";
		// transactionSalesAssociate
		// transactionCustomer
		// transactionCar
		transactionTotal = 0.0;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public SalesAssociate getTransactionSalesAssociate() {
		return transactionSalesAssociate;
	}

	public void setTransactionSalesAssociate(SalesAssociate transactionSalesAssociate) {
		this.transactionSalesAssociate = transactionSalesAssociate;
	}

	public Customer getTransactionCustomer() {
		return transactionCustomer;
	}

	public void setTransactionCustomer(Customer transactionCustomer) {
		this.transactionCustomer = transactionCustomer;
	}

	public Car getTransactionCar() {
		return transactionCar;
	}

	public void setTransactionCar(Car transactionCar) {
		this.transactionCar = transactionCar;
	}

	public double getTransactionTotal() {
		return transactionTotal;
	}

	public void setTransactionTotal(double transactionTotal) {
		this.transactionTotal = transactionTotal;
	}

}
