package com.jnapolin.lab5;

public class Car {

	private String carMake;
	private String carModel;
	private String carVIN;
	private String carYear;
	private String carColor;
	private double carValue;

	public Car() {
		carMake = "";
		carModel = "";
		carVIN = "";
		carYear = "";
		carColor = "";
		carValue = 0.0;
	}

	public Car(String carMake, String carModel, String carVin, String carYear, String carColor, double carValue) {
		this();
		this.carMake = carMake;
		this.carModel = carModel;
		this.carVIN = carVin;
		this.carYear = carYear;
		this.carColor = carColor;
		this.carValue = carValue;
	}

	public Car(String currentLine) {
		String[] carArray = currentLine.split(",");
		this.carMake = carArray[0];
		this.carModel = carArray[1];
		this.carVIN = carArray[2];
		this.carYear = carArray[3];
		this.carColor = carArray[4];
		this.carValue = Double.parseDouble(carArray[5]);
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

	public String getCarVIN() {
		return carVIN;
	}

	public void setCarVIN(String carVIN) {
		this.carVIN = carVIN;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
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

	public String toString() {
		return "Make > " + carMake + "/nModel > " + carModel + "\nVIN > " + carVIN + "\nYear > " + carYear
				+ "\nColor > " + carColor + "\nValue > $" + carValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carVIN == null) ? 0 : carVIN.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carVIN == null) {
			if (other.carVIN != null)
				return false;
		} else if (!carVIN.equals(other.carVIN))
			return false;
		return true;
	}

}
