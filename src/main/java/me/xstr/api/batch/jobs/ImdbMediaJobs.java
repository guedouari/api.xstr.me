package me.xstr.api.batch.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import me.xstr.api.batch.listeners.JobCompletionNotificationListener;

@Component
public class ImdbMediaJobs {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	Step imdbRawMediaStep;
	
	@Autowired
	Step anidbRawTitlesStep;
	
	//@Autowired
	//Step xstrMediaStep;
	
	@Bean
	public Job importImdbJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importImdbJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(imdbRawMediaStep)
				//.next(anidbRawTitlesStep)
				//.next(xstrMediaStep)
				.end().build();
	}

}
