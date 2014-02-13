package fr.xebia.training.androidjobqueueretrofit;

import android.app.Application;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 06:50
 */
public class JobQueueApplication extends Application {

    private static JobQueueApplication instance;
    private JobManager jobManager;

    public JobQueueApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        configureJobManager();

    }

    private void configureJobManager() {
        Configuration configuration = new Configuration.Builder(this)
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120)//wait 2 minute
                .build();
        jobManager = new JobManager(this, configuration);
    }

    public JobManager getJobManager() {
        return jobManager;
    }

    public static JobQueueApplication getInstance() {
        return instance;
    }
}
