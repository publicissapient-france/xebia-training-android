package fr.xebia.training.aa.fragment;

import android.app.Fragment;
import android.widget.ListView;
import android.widget.Toast;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import fr.xebia.training.aa.R;
import fr.xebia.training.aa.activity.BoxOfficeActivity;
import fr.xebia.training.aa.adapter.BoxOfficeAdapter;
import fr.xebia.training.aa.model.BoxOffice;
import fr.xebia.training.aa.model.Movie;
import fr.xebia.training.aa.service.NetworkSpiceService;
import fr.xebia.training.aa.service.request.BoxOfficeRequest;
import org.androidannotations.annotations.*;


@EFragment(R.layout.fragment_listmovies)
public class BoxOfficeFragment extends Fragment {

    SpiceManager mSpiceManager = new SpiceManager(NetworkSpiceService.class);

    @ViewById(R.id.listmovies_listview)
    ListView mBoxOfficeListView;

    @Bean
    BoxOfficeAdapter mBoxOfficeAdapter;


    @Bean
    BoxOfficeRequest mBoxOfficeRequest;

    @InstanceState
    BoxOffice mBoxOffice;


    @AfterViews
    void afterViewCreated() {
        mBoxOfficeListView.setAdapter(mBoxOfficeAdapter);

        mSpiceManager.execute(mBoxOfficeRequest, new RequestListener<BoxOffice>() {
            @Override
            public void onRequestFailure(SpiceException e) {
                Toast.makeText(getActivity(), "CA MARCHE PAS", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRequestSuccess(BoxOffice boxOffice) {
                updateBoxOffice(boxOffice);
            }
        });
    }


    public void updateBoxOffice(final BoxOffice boxOffice) {
        mBoxOffice = boxOffice;
        mBoxOfficeAdapter.setData(boxOffice.getMovies());
    }

    @ItemClick(R.id.listmovies_listview)
    void onItemClick(Movie movie) {
        ((BoxOfficeActivity) getActivity()).onMovieSelected(movie);
    }


    @Override
    public void onStart() {
        super.onStart();
        mSpiceManager.start(getActivity());
    }

    @Override
    public void onStop() {
        mSpiceManager.shouldStop();
        super.onStop();
    }

}
