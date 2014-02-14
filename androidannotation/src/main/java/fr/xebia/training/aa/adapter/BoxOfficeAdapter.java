package fr.xebia.training.aa.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import fr.xebia.training.aa.model.Movie;
import fr.xebia.training.aa.view.MovieView;
import fr.xebia.training.aa.view.MovieView_;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

@EBean
public class BoxOfficeAdapter extends BaseAdapter {

    ArrayList<Movie> mMovieArrayList = new ArrayList<Movie>();

    @RootContext
    Context mContext;

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

        MovieView view;
        if (convertView == null) {
            view = MovieView_.build(mContext);
        } else {
            view = (MovieView) convertView;
        }

        view.bind(getItem(position));

        return view;
    }

    public void setData(List<Movie> movies){
        mMovieArrayList.clear();
        if(movies!=null && !movies.isEmpty()){
            mMovieArrayList.addAll(movies);
        }

        notifyDataSetChanged();
    }
}
