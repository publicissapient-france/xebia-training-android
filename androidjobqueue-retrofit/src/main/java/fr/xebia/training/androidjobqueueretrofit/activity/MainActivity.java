package fr.xebia.training.androidjobqueueretrofit.activity;

import android.os.Bundle;
import com.path.android.jobqueue.JobManager;
import de.greenrobot.event.EventBus;
import fr.xebia.training.androidjobqueueretrofit.JobQueueApplication;
import fr.xebia.training.androidjobqueueretrofit.R;
import fr.xebia.training.androidjobqueueretrofit.event.BoxOfficeDownloadedEvent;
import fr.xebia.training.androidjobqueueretrofit.fragment.ListMovieFragment;
import fr.xebia.training.androidjobqueueretrofit.job.BoxOfficeJob;


/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:06
 */
public class MainActivity extends BaseActivity {


    ListMovieFragment mFragment;
    JobManager mJobManager = JobQueueApplication.getInstance().getJobManager();
    EventBus mEventBus = EventBus.getDefault();
    BoxOfficeJob boxOfficeJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = (ListMovieFragment) getFragmentManager().findFragmentById(R.id.listmovie_fragment);
        boxOfficeJob = new BoxOfficeJob();


    }


    @Override
    protected void onResume() {
        super.onResume();
        mEventBus.register(this);
        mJobManager.addJobInBackground(boxOfficeJob);
    }

    @Override
    protected void onPause() {
        mEventBus.unregister(this);
        super.onPause();
    }

    public void onEventMainThread(BoxOfficeDownloadedEvent event){
        mFragment.updateBoxOffice(event.boxOffice);
    }

}
