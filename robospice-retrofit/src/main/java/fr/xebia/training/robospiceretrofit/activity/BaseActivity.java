package fr.xebia.training.robospiceretrofit.activity;

import android.app.Activity;
import com.octo.android.robospice.SpiceManager;
import fr.xebia.training.robospiceretrofit.service.NetworkSpiceService;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:25
 */
public abstract class BaseActivity extends Activity {

    protected SpiceManager mSpiceManager = new SpiceManager(NetworkSpiceService.class);

    @Override
    protected void onStart() {
        super.onStart();
        mSpiceManager.start(this);
    }

    @Override
    protected void onStop() {
        mSpiceManager.shouldStop();
        super.onStop();
    }
}
