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
import com.codingWorld.covid19batchprocessing.model.StateWiseCovidStats;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public FlatFileItemReader<StateWiseCovidStats> reader() {
		FlatFileItemReader<StateWiseCovidStats> fileItemReader = new FlatFileItemReader<StateWiseCovidStats>();
		fileItemReader.setResource(new ClassPathResource("state-wise.csv"));
		fileItemReader.setLinesToSkip(1);
	    fileItemReader.setLineMapper(new DefaultLineMapper<StateWiseCovidStats>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(StateWiseCovidStats.fields());
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<StateWiseCovidStats>() {
					{
						setTargetType(StateWiseCovidStats.class);
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
	public JdbcBatchItemWriter<StateWiseCovidStats> writer(DataSource dataSource) {
	  return new JdbcBatchItemWriterBuilder<StateWiseCovidStats>()
	    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	    .sql("INSERT INTO state_wise_covid_stats (state, confirmed,recovered,deaths,active,state_code) VALUES (:state, :confirmed,:recovered,:deaths,:active,:stateCode)")
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
	public Step step1(JdbcBatchItemWriter<StateWiseCovidStats> writer) {
	  return stepBuilderFactory.get("step1")
	    .<StateWiseCovidStats, StateWiseCovidStats> chunk(10)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer)
	    .allowStartIfComplete(true)
	    .build();
	}
}
