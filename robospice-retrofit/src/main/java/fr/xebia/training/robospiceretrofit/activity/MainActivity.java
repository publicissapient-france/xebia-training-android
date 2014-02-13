package fr.xebia.training.robospiceretrofit.activity;

import android.os.Bundle;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import fr.xebia.training.robospiceretrofit.R;
import fr.xebia.training.robospiceretrofit.fragment.ListMovieFragment;
import fr.xebia.training.robospiceretrofit.model.BoxOffice;
import fr.xebia.training.robospiceretrofit.request.BoxOfficeRequest;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:06
 */
public class MainActivity extends BaseActivity {


    ListMovieFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = (ListMovieFragment) getFragmentManager().findFragmentById(R.id.listmovie_fragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSpiceManager.execute(new BoxOfficeRequest(), new RequestListener<BoxOffice>() {
            @Override
            public void onRequestFailure(SpiceException e) {

            }

            @Override
            public void onRequestSuccess(BoxOffice boxOffice) {
                mFragment.updateBoxOffice(boxOffice);
            }
        });
    }
}
