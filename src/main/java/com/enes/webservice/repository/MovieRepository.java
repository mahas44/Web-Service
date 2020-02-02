package com.enes.webservice.repository;

import com.enes.webservice.model.MyMovie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<MyMovie, Integer> {
}
