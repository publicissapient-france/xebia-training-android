package fr.xebia.training.retrofitembeddedkeystore;

import android.app.Application;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import java.util.HashMap;
import java.util.Map;

/**
 * User: mounirboudraa
 * Date: 14/02/2014
 * Time: 04:02
 */
public class KeystoreApplication extends Application {

    private static KeystoreApplication sInstance;

    private RestAdapter mRestAdapter;
    private final Map<Class<?>, Object> mRetrofitServiceMap = new HashMap<Class<?>, Object>();


    public static KeystoreApplication getInstance() {
        return sInstance;
    }

    public KeystoreApplication() {
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initRetrofit();
    }

    @SuppressWarnings("unchecked")
    public <T> T getRetrofitService(Class<T> serviceClass) {
        synchronized (mRetrofitServiceMap) {
            T service = (T) mRetrofitServiceMap.get(serviceClass);
            if (service == null) {
                service = mRestAdapter.create(serviceClass);
                mRetrofitServiceMap.put(serviceClass, service);
            }
            return service;
        }
    }

    private void initRetrofit() {

        KeyStoreConfiguration conf = new KeyStoreConfiguration(R.raw.keystore, "keystore");
        OkHttpClient okHttpClient = null;
        try {
            okHttpClient = OkHttpClientFactory.getInstance()
                    .newSecuredHttpClient(this, conf);
        } catch (Exception e) {
            Log.e("RETROFIT", "Failed to create Secured Http Client -> " + e);
        }


        RestAdapter.Builder builder = new RestAdapter.Builder();
        if (okHttpClient != null) {
            builder.setClient(new OkClient(okHttpClient));
        }
        mRestAdapter = builder.build();

    }


}
