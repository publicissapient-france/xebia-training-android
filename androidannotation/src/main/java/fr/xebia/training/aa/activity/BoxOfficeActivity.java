package fr.xebia.training.aa.activity;

import android.app.Activity;
import android.content.Intent;
import fr.xebia.training.aa.R;
import fr.xebia.training.aa.fragment.BoxOfficeFragment;
import fr.xebia.training.aa.model.Movie;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentById;


@EActivity(R.layout.activity_main)
public class BoxOfficeActivity extends Activity {


    @FragmentById(R.id.listmovie_fragment)
    BoxOfficeFragment mBoxOfficeFragment;

    @AfterViews
    void afterActivityCreated() {

    }




    public void onMovieSelected(Movie movie) {
        Intent intent = new Intent(this, DetailActivity_.class);
        intent.putExtra("movie", movie);

        startActivity(intent);
    }
}
