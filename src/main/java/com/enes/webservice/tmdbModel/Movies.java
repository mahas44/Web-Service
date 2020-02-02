
package com.enes.webservice.tmdbModel;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@Document(collection = "results")
public class Movies {


    private Long page;
    private List<Result> results;
    private Long totalPages;
    private Long totalResults;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

}
