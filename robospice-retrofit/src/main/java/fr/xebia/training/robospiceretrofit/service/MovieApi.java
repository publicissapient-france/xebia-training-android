package fr.xebia.training.robospiceretrofit.service;

import fr.xebia.training.robospiceretrofit.model.BoxOffice;
import retrofit.http.GET;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:31
 */
public interface MovieApi {

    @GET("/lists/movies/box_office.json")
    BoxOffice listMovies();

}
