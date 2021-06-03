package com.dheeraj.RestApiClient.View;

import java.util.Iterator;
import java.util.List;

import com.dheeraj.RestApiClient.DataModel.JsonDataModel;
import com.dheeraj.RestApiClient.Input.UserInput;

/*
 * Class to display data to User
 * 
 */
public class DisplayData {
	// instance members
	List<JsonDataModel> list;
	String[] weatherStrings;
	String[] windSpeedStrings;
	String[] pressureStrings;
	private String dateMonthYearString;
	int i;

	// getting list reference from other classes.
	public void setListData(final List<JsonDataModel> list) {
		this.list = list;
	}

	// displaying menu to users.
	public void displayMenu() {
		final UserInput userInput = new UserInput();

		do {
			System.out.println("*************************");
			System.out.println("1. Get Weather");
			System.out.println("2. Get WindSpeed");
			System.out.println("3. Get Pressure");
			System.out.println("0. Exit");
			System.out.println("Enter your choice(0-3) : \n");
			i = userInput.getChoice();

			switch (i) {
			case 1:

			case 2:

			case 3:
				final String dataString = userInput.getDateInput();
				if (dataString.equals("noData"))
					System.out.println("Please enter valid date");
				else {
					dateMonthYearString = dataString;
					display();
				}
				break;

			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		} while (i != 0);

	}

	void display() {
		final Iterator<JsonDataModel> iterator = list.iterator();
		boolean match = false;
		while (iterator.hasNext()) {

			final JsonDataModel jsonDataModel = iterator.next();
			if (jsonDataModel.getDateTimeString().contains(dateMonthYearString)) {
				System.out.println("*************************");
				System.out.println("TimeStamp : " + jsonDataModel.getDateTimeString());
				if (i == 1) {
					System.out.println("Temp (Kelvin): " + jsonDataModel.getWeather());
					match = true;
				}
				if (i == 2) {
					System.out.println("Wind Speed (meter/sec) : " + jsonDataModel.getWindSpeed());
					match = true;
				}
				if (i == 3) {
					System.out.println("Pressure (hPa): " + jsonDataModel.getPressure());
					match = true;
				}
			}
		}
		if (match == false) {
			System.out.println("No data found for date inputs");
		}
	}
}
