package com.jnapolin.lab5;

public class Car {

	private String carMake;
	private String carModel;
	private String carVin;
	private int carYear;
	private String carColor;
	private double carValue;
	
	
	public Car() {
		carMake = "";
		carModel = "";
		carVin = "";
		carYear = 0;
		carColor = "";
		carValue = 0.0;
	}
	
	public Car(String carMake, String carModel, String carVin, int carYear, String carColor, double carValue) {
		this();
		this.carMake = carMake;
		this.carModel = carModel;
		this.carVin = carVin;
		this.carYear = carYear;
		this.carColor = carColor;
		this.carValue = carValue;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarVin() {
		return carVin;
	}

	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public double getCarValue() {
		return carValue;
	}

	public void setCarValue(double carValue) {
		this.carValue = carValue;
	}
	
}
