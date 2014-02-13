package fr.xebia.training.androidjobqueueretrofit.model;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:22
 */
public class Movie {

    private long id;
    private int year;
    private String title;
    private MoviePosters posters;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MoviePosters getPosters() {
        return posters;
    }

    public void setPosters(MoviePosters posters) {
        this.posters = posters;
    }
}
