package fr.xebia.training.androidjobqueueretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import fr.xebia.training.androidjobqueueretrofit.R;
import fr.xebia.training.androidjobqueueretrofit.model.Movie;
import fr.xebia.training.androidjobqueueretrofit.view.ListMoviesRowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:22
 */
public class ListMovieAdapter extends BaseAdapter {

    private final Context mContext;
    private ArrayList<Movie> mMovieArrayList = new ArrayList<Movie>();

    public ListMovieAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mMovieArrayList.size();
    }

    @Override
    public Movie getItem(int position) {
        return mMovieArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListMoviesRowLayout view;

        if (convertView == null) {
            view = (ListMoviesRowLayout) LayoutInflater.from(mContext).inflate(R.layout.listmovies_row, null);
        } else {
            view = (ListMoviesRowLayout) convertView;
        }

        assert view != null;
        view.bindMovie(getItem(position));

        return view;
    }

    public void setMovies(List<Movie> movies) {
        mMovieArrayList.clear();
        if (movies != null && !movies.isEmpty()) {
            mMovieArrayList.addAll(movies);
        }

        notifyDataSetChanged();
    }
}
