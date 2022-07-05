package com.codingWorld.covid19batchprocessing.model;

import java.time.LocalDate;

public class IndianCaseTimeSeries {
	
	
	private String date1;
	private LocalDate date;
	private String dailyConfirmed;
	private String totalConfirmed;
	private String dailyRecovered;
	private String totalRecovered;
	private String dailyDeceased;
	private String totalDeceased;
	
	
	public IndianCaseTimeSeries() {

	}
	
	public IndianCaseTimeSeries(String date1, LocalDate date, String dailyConfirmed, String totalConfirmed,
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
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
