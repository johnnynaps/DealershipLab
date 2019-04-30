package com.jnapolin.lab5;

public class SalesAssociate {

	private String associateId;
	private String associateName;
	private String associateAddress;
	private double associateTotalSales;
	private String associatePassword;

	public SalesAssociate() {
		associateId = "";
		associateName = "";
		associateAddress = "";
		associateTotalSales = 0.0;
		associatePassword = "";
	}

	public SalesAssociate(String associateName, String associateAddress) {
		this();
		this.associateName = associateName;
		this.associateAddress = associateAddress;
	}

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
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

}
