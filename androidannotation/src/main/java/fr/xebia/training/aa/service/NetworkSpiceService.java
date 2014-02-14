package fr.xebia.training.aa.service;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;
import fr.xebia.training.aa.api.MovieApi;

/**
 * User: mounirboudraa
 * Date: 14/02/2014
 * Time: 16:53
 */
public class NetworkSpiceService extends RetrofitGsonSpiceService {

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(MovieApi.class);
    }

    @Override
    protected String getServerUrl() {
        return MovieApi.BASE_URL;
    }
}
