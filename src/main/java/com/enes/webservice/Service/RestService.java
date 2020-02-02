package com.enes.webservice.Service;

import com.enes.webservice.tmdbModel.Movies;
import com.enes.webservice.tmdbModel.Result;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestService {
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Result> getPostsPlainJSON() {

        String url = "https://api.themoviedb.org/3/trending/movie/week?api_key=fd50bae5852bf6c2e149317a6e885416&page=2";

        ResponseEntity<Movies> response = this.restTemplate.getForEntity(url, Movies.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().getResults();
        } else {
            return null;
        }
    }

}
