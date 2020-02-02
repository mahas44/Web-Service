package com.enes.webservice.model;

import com.enes.webservice.tmdbModel.Result;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "my-movies")
public class MyMovie {


    private String trailer_url;

    private Boolean adult;
    private String backdrop_path;
    private List<Long> genre_ids;

    private Long id;
    private String media_type;
    private String original_language;
    private String original_title;

    private String overview;

    private Double popularity;
    private String poster_path;
    private String release_date;

    private String title;

    private Boolean video;
    private Double vote_average;
    private Long vote_count;


/*    public MyMovie (Result result, String youtubeUrl){
        this.trailer_url = youtubeUrl;
        this.id = result.getId();
        this.adult = result.getAdult();
        this.backdrop_path = result.getBackdrop_path();
        this.genre_ids = result.getGenre_ids();
        this.media_type = result.getMedia_type();
        this.original_language = result.getOriginal_language();
        this.original_title = result.getOriginal_title();
        this.overview = result.getOverview();
        this.popularity = result.getPopularity();
        this.poster_path = result.getPoster_path();
        this.release_date = result.getRelease_date();
        this.title = result.getTitle();
        this.video = result.getVideo();
        this.vote_average = result.getVote_average();
        this.vote_count = result.getVote_count();
    }*/

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Long> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Long> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Long getVote_count() {
        return vote_count;
    }

    public void setVote_count(Long vote_count) {
        this.vote_count = vote_count;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }
}
