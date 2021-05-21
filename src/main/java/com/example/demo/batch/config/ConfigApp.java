package com.example.demoBatchApplication.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

@Configuration
public class ConfigApp {

    private final ScheduledExecutorService scheduledExecutorService = Executors
        .newSingleThreadScheduledExecutor(new BasicThreadFactory.Builder()
            .namingPattern("task-non-daemon-%d")
            .daemon(false)
            .build());

    @PostConstruct
    public void init() {
        this.scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled task non-daemon!!!!");
        }, 1L, 1000L, TimeUnit.MILLISECONDS);
    }

}
