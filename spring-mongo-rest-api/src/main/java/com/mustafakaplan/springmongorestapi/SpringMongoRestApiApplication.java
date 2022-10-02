package com.mustafakaplan.springmongorestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMongoRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoRestApiApplication.class, args);
    }

}
