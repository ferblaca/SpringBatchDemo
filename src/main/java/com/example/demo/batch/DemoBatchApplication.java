package com.example.demoBatchApplication;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoBatchApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(com.example.demoBatchApplication.DemoBatchApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);
    }


}
