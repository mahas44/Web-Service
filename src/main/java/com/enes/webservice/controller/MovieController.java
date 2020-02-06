package com.enes.webservice.controller;

import com.enes.webservice.model.MyMovie;
import com.enes.webservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

//    public MovieController(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }

    @GetMapping()
    public List<MyMovie> getMovies(){
        return movieRepository.findAll();
    }



}
