package com.dheeraj.RestApiClient.DataModel;

/*
 * 
 * Data Model (POJO) class to Store Data Objects.
 * 
 */
public class JsonDataModel{
	String weather;
	String windSpeed;
	String pressure;
	String dateTimeString;
	public String getWeather() {
		return weather;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public String getPressure() {
		return pressure;
	}
	public void setWeather(final String weather) {
		this.weather = weather;
	}
	public void setWindSpeed(final String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public void setPressure(final String pressure) {
		this.pressure = pressure;
	}
	public String getDateTimeString() {
		return dateTimeString;
	}
	public void setDateTimeString(final String dateTimeString) {
		this.dateTimeString = dateTimeString;
	}
	
}
