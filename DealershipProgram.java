package com.jnapolin.lab5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DealershipProgram {

	public static void main(String[] args) throws IOException {

		CarDealershipSystem carDealershipSystem = new CarDealershipSystem();
		Car car = new Car();
		SalesAssociate salesAssociate = new SalesAssociate();
		Customer customer = new Customer();
//		Transaction transaction = new Transaction();
		carDealershipSystem.loadFiles();

		String userMenuChoice = null;
		String menuPrompt = "\nPlease pick your menu selection";
		Scanner keyboard = new Scanner(System.in);
		boolean userWantsToContinue = true;
		String vin;
		String model;
		String year;
		String color;
		String make;
		String value;
		int userSelection = 0;
		String menuError2 = "Selection must be a number between 1-7";
		String menuDisplay = // displays menu to screen
				"1.) Create A Car \n" + "2.) Modify A Car \n" + "3.) Delete A Car \n" + "4.) Find A Car \n"
						+ "5.) Record A Transaction \n" + "6.) Display Sales Record \n" + "7.) Display Total Sales  \n"
						+ "8.) Exit The Program";
		String modifyMenu = "1.) Change the Make \n" + "2.) Change the Model \n" + "3.) Change the VIN Number \n"
				+ "4.) Change the Year \n" + "5.) Change the Color \n" + "6.) Change the Value \n"
				+ "7.) Go Back to Main Menu ";
		String userPass;
		String userID;

		System.out.println("Please log in using your Associate ID and Password");
		System.out.println("Enter your ID");
		userID = keyboard.nextLine();
		System.out.println("Enter your Password");
		userPass = keyboard.nextLine();

		while (userWantsToContinue) {
			while (!carDealershipSystem.authenticate(userID, userPass)) {
				System.out.println("ID or Password not recognized.\n");
				System.out.println("Enter your ID");
				userID = keyboard.nextLine();
				System.out.println("Enter your Password");
				userPass = keyboard.nextLine();
			}
			System.out.println(menuDisplay);
			System.out.println(menuPrompt);
			userMenuChoice = keyboard.nextLine();
			while (!carDealershipSystem.isInt(userMenuChoice, "Value")) {
				userMenuChoice = keyboard.nextLine();
			}
			userSelection = Integer.parseInt(userMenuChoice);

			switch (userSelection) {
			case 1:
				// allows user to create a Car and passes in the user input and the arraylist of
				// cars
				// ask user for stuff below
				System.out.println("Create a Car");
				System.out.println("Please enter a VIN Number for your Car");
				vin = keyboard.nextLine();
				// System.out.println(vinNum);
				System.out.println("Please enter a Make for your Car");
				make = keyboard.nextLine();
				// System.out.println(make);
				System.out.println("Please enter a Model for your Car");
				model = keyboard.nextLine();
				System.out.println("Please enter a Year for your Car");
				year = keyboard.nextLine();
				System.out.println("Please enter a Color for your Car");
				color = keyboard.nextLine();

				System.out.println("Please enter a Value for your Car");
				value = keyboard.nextLine();
				while (!carDealershipSystem.isDouble(value, "Value")) {
					value = keyboard.nextLine();
				}
				Car newCar = new Car(make, model, vin, year, color, Double.parseDouble(value));
				System.out.println(newCar.toString());

				carDealershipSystem.addCar(make, model, vin, year, color, Double.parseDouble(value)); // show car

				break;
			case 2:
				// ask for vin then find car
				System.out.println("Please enter a VIN Number for the Car you want to modify");
				vin = keyboard.nextLine();

				if (carDealershipSystem.findCar(vin) == null) {
					System.out.println("Vehicle not found");
					break;
				}

				car = carDealershipSystem.findCar(vin);
				System.out.println(car.toString());

				// For Modifing a Car
				// findCar(vinNum, carList)
				// going to need to find the car to Modify

				// then give them a menu to select what to edit

				boolean validInput2 = false;
				while (!validInput2) {
					try {
						System.out.println(modifyMenu);
						userSelection = Integer.parseInt(keyboard.nextLine());

						while ((userSelection < 1 || userSelection > 7)) {
							System.out.println(menuError2);
							userSelection = Integer.parseInt(keyboard.nextLine());
						}
						validInput2 = true;
						break;
					} catch (InputMismatchException m) {
						System.out.println(menuError2);
					}
				}

				switch (userSelection) {
				case 1:
					System.out.println("Enter the new make");
					make = keyboard.nextLine();
					carDealershipSystem.modifyCar(car, userSelection, make);
					System.out.println(car.toString());
					break;
				case 2:
					System.out.println("Enter the new model ");
					model = keyboard.nextLine();
					carDealershipSystem.modifyCar(car, userSelection, model);
					System.out.println(car.toString());
					break;
				case 3:
					System.out.println("Enter the new VIN");
					vin = keyboard.nextLine();
					carDealershipSystem.modifyCar(car, userSelection, vin);
					System.out.println(car.toString());
					break;
				case 4:
					System.out.println("Enter the new year");
					year = keyboard.nextLine();
					carDealershipSystem.modifyCar(car, userSelection, year);
					System.out.println(car.toString());
					break;
				case 5:
					System.out.println("Enter the new color");
					color = keyboard.nextLine();
					carDealershipSystem.modifyCar(car, userSelection, color);
					System.out.println(car.toString());
					break;
				case 6:
					System.out.println("Enter the new Value");
					value = keyboard.nextLine();
					while (!carDealershipSystem.isDouble(value, "Value")) {
						value = keyboard.nextLine();
					}
					carDealershipSystem.modifyCar(car, userSelection, value);
					System.out.println(car.toString());
				case 7:
					break;
				}

				break;
			case 3:
				// For Deleting a Car
				// find the car
				System.out.println("Please enter a VIN Number for the car you want to delete");
				vin = keyboard.nextLine();
				if (carDealershipSystem.findCar(vin) == null) {
					System.out.println("Vehicle not found");
					break;
				}
				car = carDealershipSystem.findCar(vin);
				System.out.println(car.toString());
				System.out.println("Are you sure you want to delete?\n1.) Yes\n2.) Go back");
				userMenuChoice = keyboard.nextLine();
				while (!carDealershipSystem.isInt(userMenuChoice, "Value") || Integer.parseInt(userMenuChoice) < 1
						|| Integer.parseInt(userMenuChoice) > 2) {
					System.out.println("Are you sure you want to delete?\n1.) Yes\n2.) Go back");
					userMenuChoice = keyboard.nextLine();
				}

				if (Integer.parseInt(userMenuChoice) == 1) {
					carDealershipSystem.deleteCar(car);
					System.out.println("Car deleted from inventory");
				}
				break;
			case 4:
				System.out.println("1.) By Make and Model\n2.) By VIN Number");
				value = keyboard.nextLine();
				while (!carDealershipSystem.isDouble(value, "Value")) {
					value = keyboard.nextLine();
				}
				if (Integer.parseInt(value) == 1) { // figure out multiples
					System.out.println("Enter make");
					make = keyboard.nextLine();
					System.out.println("Enter model");
					model = keyboard.nextLine();

					if (carDealershipSystem.findCar(make, model) != null) {
						// fixing
						System.out.println(carDealershipSystem.findCar(make, model).toString());
					} else {
						System.out.println("Vehicle not found");
						break;
					}

				} else if (Integer.parseInt(value) == 2) {
					System.out.println("Please enter a VIN Number for the car you want to find");
					vin = keyboard.nextLine();
					if (carDealershipSystem.findCar(vin) == null) {
						System.out.println("Vehicle not found");
						break;
					}
					car = carDealershipSystem.findCar(vin);
					System.out.println(car.toString());
				} else
					System.out.println("Invalid Choice");

				// For Finding a Car
				// ask user for stuff below
				// findCar(vinNum,model,year,color,make,value, carList);

				break;
			case 5:
				System.out.println("Please enter a VIN Number for the car you want to sell");
				vin = keyboard.nextLine();
				// Recording Transactions needs the list of Transactions
				// findCar
				// recordTrans(vinNum,model,year,color,make,value,empNumber, TransList);
				// deleteCar

				if (carDealershipSystem.findCar(vin) == null) {
					System.out.println("Vehicle not found");
					break;
				}
				car = carDealershipSystem.findCar(vin);
				System.out.println(car.toString());
				System.out.println("Enter date of transaction");
				String date = keyboard.nextLine();
				System.out.println("Enter time of transaction");
				String time = keyboard.nextLine();
				System.out.println("Enter Sales Associate ID");
				String assID = keyboard.nextLine();
				while (carDealershipSystem.findAssociate(assID) == null) {
					System.out.println("Associate not found");
					System.out.println("Reenter Associate ID");
					assID = keyboard.nextLine();
				}
				salesAssociate = carDealershipSystem.findAssociate(assID);
				System.out.println("Returning Customer? \n1.) Yes\n2.) No");
				userMenuChoice = keyboard.nextLine();
				while (!carDealershipSystem.isInt(userMenuChoice, "Choice")) {
					userMenuChoice = keyboard.nextLine();
				} // error check
				if (Integer.parseInt(userMenuChoice) == 1) {
					System.out.println("Enter Customer ID");
					String cusID = keyboard.nextLine();
					while (carDealershipSystem.findCustomer(cusID) == null) {
						System.out.println("Customer not found");
						System.out.println("Reenter Customer ID");
						cusID = keyboard.nextLine();
					}
					customer = carDealershipSystem.findCustomer(cusID);
				} else if (Integer.parseInt(userMenuChoice) == 2) {
					System.out.println("Enter customer name");
					String custName = keyboard.nextLine();
					System.out.println("Enter customer ID");
					String custID = keyboard.nextLine();
					customer = carDealershipSystem.addCustomer(custID, custName);
				} else {
					System.out.println("Invalid Choice");
					break;
				}

				System.out.println("Enter Value of Sale");
				value = keyboard.nextLine();
				while (!carDealershipSystem.isDouble(value, "Value")) {
					value = keyboard.nextLine();
				}
				carDealershipSystem.makeTransaction(date, time, car, customer, salesAssociate, value);
				System.out.println("Transaction Recorded");
				break;
			case 6:
				System.out.println("Displaying your previous sales");
				// DisplaySales(empNumber, carList);

				if (carDealershipSystem.displayTransactions(userID) == null) {
					System.out.println("No transactions to display");
				} else {
					System.out.println(carDealershipSystem.displayTransactions(userID));
				}
				break;
			case 7:
				System.out.println("Displaying your total sales");
				// DisplayTotalSales(empNumber, carList);
				System.out.println("$" + carDealershipSystem.displayTotalSale(userID));
				break;
			case 8:
				userWantsToContinue = false;
				carDealershipSystem.saveFiles();
				break;
			}

		}
		System.out.println("Goodbye!");

		keyboard.close();

	}
}