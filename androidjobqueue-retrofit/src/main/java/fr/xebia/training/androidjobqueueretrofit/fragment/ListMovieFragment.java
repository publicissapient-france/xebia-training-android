package fr.xebia.training.androidjobqueueretrofit.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import fr.xebia.training.androidjobqueueretrofit.R;
import fr.xebia.training.androidjobqueueretrofit.adapter.ListMovieAdapter;
import fr.xebia.training.androidjobqueueretrofit.model.BoxOffice;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:11
 */
public class ListMovieFragment extends Fragment {

    ListView mMoviesListView;

    ListMovieAdapter mAdapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mAdapter = new ListMovieAdapter(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_listmovies, container, false);
        assert view != null;
        mMoviesListView = (ListView) view.findViewById(R.id.listmovies_listview);
        mMoviesListView.setAdapter(mAdapter);
        return view;
    }

    public void updateBoxOffice(BoxOffice boxOffice){
        mAdapter.setMovies(boxOffice.getMovies());
    }
}
