package com.example.demo.batch.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import com.example.batch.entity.Product;
import com.example.demo.batch.batch.ProductWriter;
import com.example.demoBatchApplication.batch.CsvProductReader;

@Configuration
@EnableBatchProcessing
@EnableConfigurationProperties(BatchSampleProperties.class)
public class BatchConfig {

    @Bean
    public Job job(@Qualifier("step1") Step step1, JobBuilderFactory jobs) {
        return jobs.get("myJob")
            .start(step1)
            .listener(new JobExecutionListener() {
                @Override
                public void beforeJob(JobExecution jobExecution) {
                    // Insert here beforeJob actions
                }

                @Override
                public void afterJob(JobExecution jobExecution) {
                    // Insert here afterJob actions
                }
            })
            .build();
    }

    @Bean
    public Step step1(CsvProductReader productReader, ProductWriter productWriter,
        BatchSampleProperties batchSampleProperties, StepBuilderFactory steps,
        ResourceLoader resourceLoader) {
        productReader.setDelimiter(batchSampleProperties.getDelimiter());
        productReader.setResource(resourceLoader.getResource(batchSampleProperties.getInputFile()));

        return steps.get("step1")
            .<Product, Product>chunk(batchSampleProperties.getChunkSize())
            .reader(productReader)
            .writer(productWriter)
            .listener(new StepExecutionListener() {
                @Override
                public void beforeStep(StepExecution stepExecution) {
                    // Insert here beforeStep actions
                }

                @Override
                public ExitStatus afterStep(StepExecution stepExecution) {
                    // Insert here afterStep actions
                    return ExitStatus.COMPLETED; // return the needed ExitStatus
                }
            })
            .build();
    }

}
