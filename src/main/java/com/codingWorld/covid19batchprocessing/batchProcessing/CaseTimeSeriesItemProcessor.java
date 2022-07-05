package com.codingWorld.covid19batchprocessing.batchProcessing;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.codingWorld.covid19batchprocessing.model.IndianCaseTimeSeries;
import com.codingWorld.covid19batchprocessing.model.StateWiseCovidStats;

public class CaseTimeSeriesItemProcessor implements ItemProcessor<StateWiseCovidStats, StateWiseCovidStats> {

	private static final Logger log = LoggerFactory.getLogger(CaseTimeSeriesItemProcessor.class);

	@Override
	public StateWiseCovidStats process(final StateWiseCovidStats stateWiseCovidStats) throws Exception {

//		final IndianCaseTimeSeries indianCaseTimeSeries = new IndianCaseTimeSeries();
//		indianCaseTimeSeries.setDate1(indianCaseTimeSeriesInput.getDate1());
//		indianCaseTimeSeries.setDate(LocalDate.parse(indianCaseTimeSeriesInput.getDate()));
//		indianCaseTimeSeries.setDailyConfirmed(indianCaseTimeSeriesInput.getDailyConfirmed());
//		indianCaseTimeSeries.setTotalConfirmed(indianCaseTimeSeriesInput.getTotalConfirmed());
//		indianCaseTimeSeries.setDailyRecovered(indianCaseTimeSeriesInput.getDailyRecovered());
//		indianCaseTimeSeries.setTotalRecovered(indianCaseTimeSeriesInput.getTotalRecovered());
//		indianCaseTimeSeries.setDailyDeceased(indianCaseTimeSeriesInput.getDailyDeceased());
//		indianCaseTimeSeries.setTotalDeceased(indianCaseTimeSeriesInput.getTotalDeceased());

		return stateWiseCovidStats;
	}

}