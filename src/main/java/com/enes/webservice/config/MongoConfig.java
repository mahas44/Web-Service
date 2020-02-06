package com.enes.webservice.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.enes.webservice.repository")
public class MongoConfig {

}

