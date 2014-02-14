package fr.xebia.training.aa.fragment;

import android.app.Fragment;
import android.widget.TextView;
import fr.xebia.training.aa.R;
import fr.xebia.training.aa.model.Movie;
import org.androidannotations.annotations.*;


@EFragment(R.layout.fragment_detail)
public class DetailFragment extends Fragment {

    @ViewById(R.id.detail_title)
    TextView mTitleTextView;

    @FragmentArg
    @InstanceState
    Movie mMovie;


    @AfterViews
    void afterViewCreated() {
        mTitleTextView.setText(mMovie.getTitle());
    }


}
