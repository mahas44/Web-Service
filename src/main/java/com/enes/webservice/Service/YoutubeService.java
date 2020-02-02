package com.enes.webservice.Service;

import com.enes.webservice.model.YoutubeVideo;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeService {

    private static final long MAX_SEARCH_RESULTS = 1;

    private YouTube getYouTube() {
        YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
                (reqeust) -> {}).setApplicationName("youtube-spring-boot-demo").build();

        return youtube;
    }
    /**
     * Returns the first 5 YouTube videos that match the query term
     */
    public List<YoutubeVideo> fetchVideosByQuery(String queryTerm) {
        List<YoutubeVideo> videos = new ArrayList<YoutubeVideo>();

        try {
            //instantiate youtube object
            YouTube youtube = getYouTube();

            //define what info we want to get
            YouTube.Search.List search = youtube.search().list("id,snippet");

            //set our credentials
            String apiKey = "AIzaSyCncamS2oNGnsiB-Wo-j-srBRZt4HmG0hg";
            search.setKey(apiKey);

            //set the search term
            search.setQ(queryTerm);

            //we only want video results
            search.setType("video");

            //set the fields that we're going to use
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/description,snippet/publishedAt,snippet/thumbnails/default/url)");

            //set the max results
            search.setMaxResults(MAX_SEARCH_RESULTS);


            //perform the search and parse the results
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {
                for (SearchResult result : searchResultList) {
                    YoutubeVideo video = new YoutubeVideo();
                    video.setTitle(result.getSnippet().getTitle());
                    video.setUrl(result.getId().getVideoId());
                    video.setThumbnailUrl(result.getSnippet().getThumbnails().getDefault().getUrl());
                    video.setDescription(result.getSnippet().getDescription());


                    videos.add(video);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return videos;
    }

}
