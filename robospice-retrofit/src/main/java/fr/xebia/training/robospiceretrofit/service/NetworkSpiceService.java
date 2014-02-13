package fr.xebia.training.robospiceretrofit.service;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:28
 */
public class NetworkSpiceService extends RetrofitGsonSpiceService {

    private final static String BASE_URL = "http://xebiamobiletest.herokuapp.com/api/public/v1.0";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(MovieApi.class);
    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;

    }
}
