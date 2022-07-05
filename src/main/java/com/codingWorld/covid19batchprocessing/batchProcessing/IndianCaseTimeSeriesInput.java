package com.codingWorld.covid19batchprocessing.batchProcessing;

public class IndianCaseTimeSeriesInput {
	
	
	private String date1;
	private String date;
	private String dailyConfirmed;
	private String totalConfirmed;
	private String dailyRecovered;
	private String totalRecovered;
	private String dailyDeceased;
	private String totalDeceased;
	
	public static String[] fields() {
		return new String[] {"date1","date","dailyConfirmed","totalConfirmed","dailyRecovered","totalRecovered","dailyDeceased","totalDeceased"};
	}
	
	public IndianCaseTimeSeriesInput() {

	}
	
	public IndianCaseTimeSeriesInput(String date1, String date, String dailyConfirmed, String totalConfirmed,
			String dailyRecovered, String totalRecovered, String dailyDeceased, String totalDeceased) {
		
		this.date1 = date1;
		this.date = date;
		this.dailyConfirmed = dailyConfirmed;
		this.totalConfirmed = totalConfirmed;
		this.dailyRecovered = dailyRecovered;
		this.totalRecovered = totalRecovered;
		this.dailyDeceased = dailyDeceased;
		this.totalDeceased = totalDeceased;
	}

	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDailyConfirmed() {
		return dailyConfirmed;
	}
	public void setDailyConfirmed(String dailyConfirmed) {
		this.dailyConfirmed = dailyConfirmed;
	}
	public String getTotalConfirmed() {
		return totalConfirmed;
	}
	public void setTotalConfirmed(String totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}
	public String getDailyRecovered() {
		return dailyRecovered;
	}
	public void setDailyRecovered(String dailyRecovered) {
		this.dailyRecovered = dailyRecovered;
	}
	public String getTotalRecovered() {
		return totalRecovered;
	}
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}
	public String getDailyDeceased() {
		return dailyDeceased;
	}
	public void setDailyDeceased(String dailyDeceased) {
		this.dailyDeceased = dailyDeceased;
	}
	public String getTotalDeceased() {
		return totalDeceased;
	}
	public void setTotalDeceased(String totalDeceased) {
		this.totalDeceased = totalDeceased;
	}
	
	

}
