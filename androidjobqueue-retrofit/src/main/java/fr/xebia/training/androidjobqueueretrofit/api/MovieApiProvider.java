package fr.xebia.training.androidjobqueueretrofit.api;

import retrofit.RestAdapter;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 07:16
 */
public class MovieApiProvider {

    private static final MovieApiProvider sInstance = new MovieApiProvider();

    private MovieApi mMovieApi;

    private MovieApiProvider() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(MovieApi.BASE_URL)
                .build();

        mMovieApi = restAdapter.create(MovieApi.class);
    }

    public static MovieApiProvider getInstance() {
        return sInstance;
    }

    public MovieApi getMovieApi() {
        return mMovieApi;
    }
}
