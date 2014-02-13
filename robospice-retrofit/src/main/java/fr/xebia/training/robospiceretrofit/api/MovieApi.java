package fr.xebia.training.robospiceretrofit.api;

import fr.xebia.training.robospiceretrofit.model.BoxOffice;
import retrofit.http.GET;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:31
 */
public interface MovieApi {

    public final static String BASE_URL = "http://xebiamobiletest.herokuapp.com/api/public/v1.0";

    @GET("/lists/movies/box_office.json")
    BoxOffice listMovies();

}
