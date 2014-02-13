package fr.xebia.training.androidjobqueueretrofit.job;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import de.greenrobot.event.EventBus;
import fr.xebia.training.androidjobqueueretrofit.api.MovieApi;
import fr.xebia.training.androidjobqueueretrofit.api.MovieApiProvider;
import fr.xebia.training.androidjobqueueretrofit.event.BoxOfficeDownloadedEvent;
import fr.xebia.training.androidjobqueueretrofit.model.BoxOffice;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 07:02
 */
public class BoxOfficeJob extends Job {

    private MovieApi mMovieApi = MovieApiProvider.getInstance().getMovieApi();

    public BoxOfficeJob() {
        super(new Params(Priority.MIDDLE).requireNetwork());
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        BoxOffice boxOffice= mMovieApi.listMovies();
        EventBus.getDefault().post(new BoxOfficeDownloadedEvent(boxOffice));
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
