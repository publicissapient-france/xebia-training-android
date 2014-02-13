package fr.xebia.training.robospiceretrofit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import fr.xebia.training.robospiceretrofit.R;
import fr.xebia.training.robospiceretrofit.model.Movie;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 06:10
 */
public class ListMoviesRowLayout extends RelativeLayout {

    ImageView mPosterImageView;
    TextView mTitletextTextView;
    TextView mSubTitletextTextView;

    Context mContext;

    public ListMoviesRowLayout(Context context) {
        super(context);
        mContext = context;
    }

    public ListMoviesRowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public ListMoviesRowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mPosterImageView = (ImageView) findViewById(R.id.listmovies_row_imageview);
        mTitletextTextView = (TextView) findViewById(R.id.listmovies_row_title_textview);
        mSubTitletextTextView = (TextView) findViewById(R.id.listmovies_row_subtitle_textview);
    }


    public void bindMovie(Movie movie){
        mTitletextTextView.setText(movie.getTitle());
        mSubTitletextTextView.setText(String.valueOf(movie.getYear()));
        Picasso.with(mContext).load(movie.getPosters().getProfile()).into(mPosterImageView);
    }
}
