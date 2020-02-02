package com.enes.webservice;

import com.enes.webservice.Service.RestService;
import com.enes.webservice.Service.YoutubeService;
import com.enes.webservice.model.MyMovie;
import com.enes.webservice.model.YoutubeVideo;
import com.enes.webservice.repository.MovieRepository;

import com.enes.webservice.tmdbModel.Result;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class Main {
//	private RestService restService;
//	private YoutubeService youtubeService;
//	MovieRepository movieRepository;
//	public Main(RestService restService, YoutubeService youtubeService, MovieRepository movieRepository) {
//		this.restService = restService;
//		this.youtubeService = youtubeService;
//		this.movieRepository = movieRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		/*List<Result> result = restService.getPostsPlainJSON();
//
//		for (Result value : result) {
//			List<YoutubeVideo> youtubeVideo = youtubeService.fetchVideosByQuery(value.getTitle()+ " trailer");
//			MyMovie myMovie = new MyMovie(value, youtubeVideo.get(0).getUrl());
//			movieRepository.insert(myMovie);
//		}*/
//	}
}
