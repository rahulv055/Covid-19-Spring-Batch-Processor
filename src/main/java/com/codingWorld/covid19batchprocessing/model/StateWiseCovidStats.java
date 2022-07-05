package com.codingWorld.covid19batchprocessing.model;

public class StateWiseCovidStats {
	
	private String state;
	private String confirmed;
	private String recovered;
	private String deaths;
	private String active;
	private String stateCode;
	
	
	public static String[] fields() {
		return new String[] {"state","confirmed","recovered","deaths","active","stateCode"};
	}
	
	public StateWiseCovidStats() {
		
	}


	public StateWiseCovidStats(String state, String confirmed, String recovered, String deaths, String active,
			String stateCode) {
		super();
		this.state = state;
		this.confirmed = confirmed;
		this.recovered = recovered;
		this.deaths = deaths;
		this.active = active;
		this.stateCode = stateCode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getConfirmed() {
		return confirmed;
	}


	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}


	public String getRecovered() {
		return recovered;
	}


	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}


	public String getDeaths() {
		return deaths;
	}


	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	public String getStateCode() {
		return stateCode;
	}


	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}


	@Override
	public String toString() {
		return "StateWiseCovidStats [state=" + state + ", confirmed=" + confirmed + ", recovered=" + recovered
				+ ", deaths=" + deaths + ", active=" + active + ", stateCode=" + stateCode + "]";
	}	
}
