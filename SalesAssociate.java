package com.jnapolin.lab5;

public class SalesAssociate {

	private String associateID;
	private String associateName;
	private String associateAddress;
	private double associateTotalSales;
	private String associatePassword;

	public SalesAssociate() {
		associateID = "";
		associateName = "";
		associateAddress = "";
		associateTotalSales = 0.0;
		associatePassword = "";
	}

	public SalesAssociate(String currentLine) {
		String[] assArray = currentLine.split(",");
		this.associateID = assArray[0];
		this.associateName = assArray[1];
		this.associateAddress = assArray[2];
		this.associateTotalSales = Double.parseDouble(assArray[3]);
		this.associatePassword = assArray[4];
	}

	public String getAssociateID() {
		return associateID;
	}

	public void setAssociateId(String associateId) {
		this.associateID = associateId;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getAssociateAddress() {
		return associateAddress;
	}

	public void setAssociateAddress(String associateAddress) {
		this.associateAddress = associateAddress;
	}

	public double getAssociateTotalSales() {
		return associateTotalSales;
	}

	public void setAssociateTotalSales(double associateTotalSales) {
		this.associateTotalSales = associateTotalSales;
	}

	public String getAssociatePassword() {
		return associatePassword;
	}

	public void setAssociatePassword(String associatePassword) {
		this.associatePassword = associatePassword;
	}

//	public String toString() {
//		return associateID + associatePassword;
//
//	}

	public String toCSV() {
		return associateID + "," + associateName + "," + associateAddress + "," + associateTotalSales + ","
				+ associatePassword + "\r\n";
	}

	public void addSale(double value) {
		this.associateTotalSales += value;
	}

}
