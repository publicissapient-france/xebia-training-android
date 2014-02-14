package fr.xebia.training.robospiceretrofit.service;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;
import fr.xebia.training.robospiceretrofit.api.MovieApi;
import retrofit.RestAdapter;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:28
 */
public class NetworkSpiceService extends RetrofitGsonSpiceService {



    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(MovieApi.class);
    }

    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        return new RestAdapter.Builder()
                    .setServer(getServerUrl());
    }

    @Override
    protected String getServerUrl() {
        return MovieApi.BASE_URL;

    }
}
