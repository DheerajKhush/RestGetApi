package com.dheeraj.RestApiClient.Input;

import java.util.Scanner;

/*
 * Class to Take user inputs.
 * 
 */
public class UserInput {
	Scanner scanner;

	public UserInput() {
		scanner = new Scanner(System.in);
	}

	private String dateMonthYearString;

	public int getChoice() {
		return scanner.nextInt();
	}

	public String getDateInput() {

		System.out.println("Enter date (27-31):");
		int date = scanner.nextInt();
		if (date >= 27 && date <= 31) {

			System.out.println("Enter month (03):");
			int month = scanner.nextInt();
			if (month == 03) {
				System.out.println("Enter year (2019):");
				int year = scanner.nextInt();
				if (year == 2019) {
					dateMonthYearString = String.format("%s-0%s-%s", year, month, date);
					return dateMonthYearString;
				}
			}
		}
		return "noData";

	}

}
