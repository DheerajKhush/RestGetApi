package com.dheeraj.RestApiClient;

import com.dheeraj.RestApiClient.HttpCall.RestWorker;
import com.dheeraj.RestApiClient.View.DisplayData;

/*
 * 
 * Driver Class to perform Execution
 * 
 */
public class RestClientApp {
	// URLString
	static String urlString = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";

	public static void main(String[] args) {
		// Rest API Call
		RestWorker restWorker = new RestWorker(urlString);
		restWorker.callRestApi();

		// Initialization of Data members
		DisplayData displayData = new DisplayData();
		displayData.setListData(restWorker.getListData());
		// Display Menu to User
		displayData.displayMenu();

	}
}
