package com.jnapolin.lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarDealershipSystem {

	public List<SalesAssociate> salesAssociates = new ArrayList<>();
	public List<Customer> customers = new ArrayList<>();
	public List<Car> cars = new ArrayList<>();
	public List<Transaction> transactions = new ArrayList<>();
	public List<Car> sold = new ArrayList<>();

	public boolean authenticate(String assID, String assPass) {

		for (SalesAssociate associate : salesAssociates) {
			if (associate.getAssociateID().equals(assID) && associate.getAssociatePassword().equals(assPass)) {
				return true;
			}
		}
		return false;
	}

	public void loadFiles() throws IOException {
		loadCars();
		loadSalesAssociates();
		loadTransactions();
		loadCustomers();
		loadSold();
	}

	private void loadCars() throws IOException {
		File testFile = new File("E:/Users/johnn/Documents/cars.txt");
		BufferedReader reader = new BufferedReader(new FileReader(testFile));
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {

			Car car = new Car(currentLine);
			cars.add(car);
		}
		reader.close();
	}

	private void loadSalesAssociates() throws IOException {
		File testFile = new File("E:/Users/johnn/Documents/employees.txt");
		BufferedReader reader = new BufferedReader(new FileReader(testFile));
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {

			SalesAssociate associate = new SalesAssociate(currentLine);
			salesAssociates.add(associate);
		}
		reader.close();
	}

	private void loadTransactions() throws IOException {
		File testFile = new File("E:/Users/johnn/Documents/transactions.txt");
		BufferedReader reader = new BufferedReader(new FileReader(testFile));
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {

			Transaction transaction = new Transaction(currentLine);
			transactions.add(transaction);
		}
		reader.close();
	}

	private void loadCustomers() throws IOException {
		File testFile = new File("E:/Users/johnn/Documents/customers.txt");
		BufferedReader reader = new BufferedReader(new FileReader(testFile));
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {

			Customer customer = new Customer(currentLine);
			customers.add(customer);
		}
		reader.close();
	}

	private void loadSold() throws IOException {
		File testFile = new File("E:/Users/johnn/Documents/sold.txt");
		BufferedReader reader = new BufferedReader(new FileReader(testFile));
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {

			Car car = new Car(currentLine);
			sold.add(car);
		}
		reader.close();
	}

	public void addCar(String make, String model, String vin, String year, String color, double value)
			throws IOException {
		Car car = new Car(make, model, vin, year, color, value);
		cars.add(car);
	}

	public Car findCar(String vin) {
		for (Car car : cars) {
			if (car.getCarVIN().equals(vin)) {
				return car;
			}
		}
		return null;
	}

	public ArrayList<String> findCar(String make, String model) { // figure out multiples
		ArrayList<String> searchResults = new ArrayList<>();
		for (Car car : cars) {
			if (car.getCarMake().equals(make.toUpperCase()) && car.getCarModel().equals(model.toUpperCase())) {
				searchResults.add(car.toArrayList());
			}
		}
		if (searchResults.isEmpty()) {
			return null;
		}
		return searchResults;
	}

	public SalesAssociate findAssociate(String assID) {
		for (SalesAssociate associate : salesAssociates) {
			if (associate.getAssociateID().equals(assID)) {
				return associate;
			}
		}
		return null;
	}

	public Customer findCustomer(String cusID) {
		for (Customer customer : customers) {
			if (customer.getCustomerId().equals(cusID)) {
				return customer;
			}
		}
		return null;
	}

	public void modifyCar(Car car, int choice, String change) {
		switch (choice) {
		case 1:
			car.setCarMake(change.toUpperCase());
			break;
		case 2:
			car.setCarModel(change.toUpperCase());
			break;
		case 3:
			car.setCarVIN(change);
			break;
		case 4:
			car.setCarYear(change);
			break;
		case 5:
			car.setCarColor(change);
			break;
		case 6:
			car.setCarValue(Double.parseDouble(change));
			break;
		}
	}

	public void deleteCar(Car car) throws IOException {
		cars.remove(car);
	}

	public void saveFiles() throws IOException {
		saveCars();
		saveCustomers();
		saveSalesAssociates();
		saveSold();
		saveTransactions();
	}

	private void saveCars() throws IOException {
		FileWriter testFile = new FileWriter("E:/Users/johnn/Documents/cars.txt");
		BufferedWriter writer = new BufferedWriter(testFile);

		for (Car car : cars) {
			writer.write(car.toCSV());
		}
		writer.close();
	}

	private void saveCustomers() throws IOException {
		FileWriter testFile = new FileWriter("E:/Users/johnn/Documents/customers.txt");
		BufferedWriter writer = new BufferedWriter(testFile);

		for (Customer customer : customers) {
			writer.write(customer.toCSV());
		}
		writer.close();
	}

	private void saveTransactions() throws IOException {
		FileWriter testFile = new FileWriter("E:/Users/johnn/Documents/transactions.txt");
		BufferedWriter writer = new BufferedWriter(testFile);

		for (Transaction transaction : transactions) {
			writer.write(transaction.toCSV());
		}
		writer.close();
	}

	private void saveSalesAssociates() throws IOException {
		FileWriter testFile = new FileWriter("E:/Users/johnn/Documents/employees.txt");
		BufferedWriter writer = new BufferedWriter(testFile);

		for (SalesAssociate associate : salesAssociates) {
			writer.write(associate.toCSV());
		}
		writer.close();
	}

	private void saveSold() throws IOException {
		FileWriter testFile = new FileWriter("E:/Users/johnn/Documents/sold.txt");
		BufferedWriter writer = new BufferedWriter(testFile);

		for (Car car : sold) {
			writer.write(car.toCSV());
		}
		writer.close();
	}

	public void makeTransaction(String date, String time, Car car, Customer customer, SalesAssociate salesAssociate,
			String value) throws IOException {
		Transaction transaction = new Transaction(date, time, salesAssociate.getAssociateID(), customer.getCustomerId(),
				car.getCarVIN(), Double.parseDouble(value));
		transactions.add(transaction);
		sold.add(car);
		salesAssociate.addSale(Double.parseDouble(value));
		deleteCar(car);
	}

//	public String displayTransactions(String empID) {
//		for (Transaction transaction : transactions) {
//			if (transaction.getTransactionSalesAssociate().equals(empID)) {
//				return transaction.toString();
//			}
//		}
//		return null;
//	}

	public ArrayList<String> displayTransactions(String empID) { // figure out multiples
		ArrayList<String> searchResults = new ArrayList<>();
		for (Transaction transaction : transactions) {
			if (transaction.getTransactionSalesAssociate().equals(empID)) {
				searchResults.add(transaction.toString());
			}
		}
		if (searchResults.isEmpty()) {
			return null;
		}
		return searchResults;
	}

	public double displayTotalSale(String empID) {
		for (SalesAssociate associate : salesAssociates) {
			if (associate.getAssociateID().equals(empID)) {
				return associate.getAssociateTotalSales();
			}
		}
		return 0; // DNE or some error
	}

	public boolean isDouble(String value, String description) {
		value.trim();
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException ex) {
			System.err.println("Invalid " + description + ". Enter Valid " + description);
			return false;
		}
	}

	public boolean isInt(String value, String description) {
		value.trim();
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException ex) {
			System.err.println("Invalid " + description + ". Enter Valid " + description);
			return false;
		}
	}

	public Customer addCustomer(String custID, String custName) throws IOException {
		Customer customer = new Customer(custID, custName);
		customers.add(customer);
		return customer;
	}
}
