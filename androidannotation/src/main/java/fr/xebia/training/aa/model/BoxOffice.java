package fr.xebia.training.aa.model;

import java.io.Serializable;
import java.util.List;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:38
 */


public class BoxOffice implements Serializable{
    private List<Movie> movies;


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
