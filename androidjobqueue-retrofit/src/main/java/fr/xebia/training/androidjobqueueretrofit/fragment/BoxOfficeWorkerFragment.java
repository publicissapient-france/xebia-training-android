package fr.xebia.training.androidjobqueueretrofit.fragment;

import android.app.Fragment;
import android.os.Bundle;
import de.greenrobot.event.EventBus;
import fr.xebia.training.androidjobqueueretrofit.JobQueueApplication;
import fr.xebia.training.androidjobqueueretrofit.job.BoxOfficeJob;

public class BoxOfficeWorkerFragment extends Fragment{


    private EventBus mEventBus = EventBus.getDefault();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    public void retrieveBoxOffice(){
        JobQueueApplication.getInstance().getJobManager().addJobInBackground(new BoxOfficeJob());
    }

}
