package com.jnapolin.lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//login xx
//menu
//edit/modify/delete cars
//make transaction (find/select car)
//find car by make/model
//record transactions/sales with append mode
//display cars sold by employee (menu function)
//display employee with total sales
//store cars in cars.txt
//input validation
//instructions each step

//take strings for make and model and search for car object
//read cars.txt and store Car object in collection done in constructor
//read employees.txt and create SalesAssociate object blah blah in constructor
//takes Car, SalesAssociate, Customer objects and creates a Transaction object (see word doc)
//save new transactions to transactions.txt (not overwrite)
//save cars(overwrite)
//save employees(overwrite)

public class CarDealershipSystem {

	public List<SalesAssociate> salesAssociates = new ArrayList<>();
	public List<Customer> customers = new ArrayList<>();
	public List<Car> cars = new ArrayList<>();
	public List<Transaction> transactions = new ArrayList<>();
	public List<Car> sold = new ArrayList<>(); 

	public void start() throws IOException {
		loadFiles();
		Scanner scanner = new Scanner(System.in);
		boolean userWantsToContinue = true;
		String userId;
		String userPass;

		System.out.println("Please log in using your Associate ID and Password");
		System.out.println("Enter your ID");
		userId = scanner.nextLine();
		System.out.println("Enter your Password");
		userPass = scanner.nextLine();

		while (userWantsToContinue) {
			while (!authenticate(userId, userPass)) {
				System.out.println("Sorry\n");
				System.out.println("Enter your ID");
				userId = scanner.nextLine();
				System.out.println("Enter your Password");
				userPass = scanner.nextLine();
			}
		}
		scanner.close();
	}

	public boolean authenticate(String assId, String assPass) {

		for (SalesAssociate associate : salesAssociates) {
			if (associate.getAssociateId().equals(assId) && associate.getAssociatePassword().equals(assPass)) {
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

	public void addInventory(String make, String model, String VIN, String year, String color, double value)
			throws IOException {
		Car car = new Car(make, model, VIN, year, color, value);
		cars.add(car);
	}

	public Car findCar(String VIN) {
		for (Car car : cars) {
			if (car.getCarVIN() == VIN) {
				System.out.println(car.toString());
				return car;
			}
		}
		return null;
	}

	public void modifyCar(Car car, int choice, String change) {
		switch (choice) {
		case 1:
			car.setCarMake(change);
		case 2:
			car.setCarModel(change);
		case 3:
			car.setCarVIN(change);
		case 4:
			car.setCarYear(change);
		case 5:
			car.setCarColor(change);
		case 6:
			car.setCarValue(Double.parseDouble(change));
		}
	}

	public void saveFiles() {

	}

	public void deleteCar(Car car) {
		cars.remove(car);
	}
}
