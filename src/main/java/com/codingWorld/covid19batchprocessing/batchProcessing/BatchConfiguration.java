package com.codingWorld.covid19batchprocessing.batchProcessing;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.codingWorld.covid19batchprocessing.model.IndianCaseTimeSeries;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public FlatFileItemReader<IndianCaseTimeSeriesInput> reader() {
		FlatFileItemReader<IndianCaseTimeSeriesInput> fileItemReader = new FlatFileItemReader<IndianCaseTimeSeriesInput>();
		fileItemReader.setResource(new ClassPathResource("case-time-series.csv"));
		fileItemReader.setLinesToSkip(1);
	    fileItemReader.setLineMapper(new DefaultLineMapper<IndianCaseTimeSeriesInput>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(IndianCaseTimeSeriesInput.fields());
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<IndianCaseTimeSeriesInput>() {
					{
						setTargetType(IndianCaseTimeSeriesInput.class);
					}
				});
			}
		});
//	    .delimited()
//	    .names(IndianCaseTimeSeriesInput.fields())
//	    .fieldSetMapper(new BeanWrapperFieldSetMapper<IndianCaseTimeSeriesInput>() {{
//	      setTargetType(IndianCaseTimeSeriesInput.class);
//	    }})
//	    .build();
		return fileItemReader;
	  
	  

	}
	
	@Bean
	public CaseTimeSeriesItemProcessor processor() {
	  return new CaseTimeSeriesItemProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<IndianCaseTimeSeries> writer(DataSource dataSource) {
	  return new JdbcBatchItemWriterBuilder<IndianCaseTimeSeries>()
	    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	    .sql("INSERT INTO indian_case_time_series (date1, date,daily_confirmed,total_confirmed,daily_recovered,total_recovered,daily_deceased,total_deceased) VALUES (:date1, :date,:dailyConfirmed,:totalConfirmed,:dailyRecovered,:totalRecovered,:dailyDeceased,:totalDeceased)")
	    .dataSource(dataSource)
	    .build();
	}
	
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
	  return jobBuilderFactory.get("importUserJob")
	    .incrementer(new RunIdIncrementer())
	    .listener(listener)
	    .flow(step1)
	    .end()
	    .build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<IndianCaseTimeSeries> writer) {
	  return stepBuilderFactory.get("step1")
	    .<IndianCaseTimeSeriesInput, IndianCaseTimeSeries> chunk(10)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer)
	    .allowStartIfComplete(true)
	    .build();
	}
}
