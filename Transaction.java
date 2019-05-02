package com.jnapolin.lab5;

public class Transaction {

	private String transactionDate;
	private String transactionTime;
	private String transactionSalesAssociate;
	private String transactionCustomer;
	private String transactionCar;
	private double transactionTotal;
		
	public Transaction(String currentLine ) {
		String transArray[] = currentLine.split(",");
		this.transactionDate = transArray[0];
		this.transactionTime = transArray[1];
		this.transactionSalesAssociate = transArray[2];
		this.transactionCustomer = transArray[3];
		this.transactionCar = transArray[4];
		this.transactionTotal = Double.parseDouble(transArray[5]);
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

	public String getTransactionSalesAssociate() {
		return transactionSalesAssociate;
	}

	public void setTransactionSalesAssociate(String transactionSalesAssociate) {
		this.transactionSalesAssociate = transactionSalesAssociate;
	}

	public String getTransactionCustomer() {
		return transactionCustomer;
	}

	public void setTransactionCustomer(String transactionCustomer) {
		this.transactionCustomer = transactionCustomer;
	}

	public String getTransactionCar() {
		return transactionCar;
	}

	public void setTransactionCar(String transactionCar) {
		this.transactionCar = transactionCar;
	}

	public double getTransactionTotal() {
		return transactionTotal;
	}

	public void setTransactionTotal(double transactionTotal) {
		this.transactionTotal = transactionTotal;
	}

}
