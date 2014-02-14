package fr.xebia.training.aa.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import fr.xebia.training.aa.R;
import fr.xebia.training.aa.model.Movie;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * User: mounirboudraa
 * Date: 14/02/2014
 * Time: 16:27
 */
@EViewGroup(R.layout.listmovies_row)
public class MovieView extends RelativeLayout {

    @ViewById(R.id.listmovies_row_imageview)
    ImageView mPosterImageView;

    @ViewById(R.id.listmovies_row_title_textview)
    TextView mTitleTextView;

    @ViewById(R.id.listmovies_row_subtitle_textview)
    TextView mSubtitleTextView;

    public MovieView(Context context) {
        super(context);
    }


    public void bind(Movie movie) {
        mTitleTextView.setText(movie.getTitle());
        mSubtitleTextView.setText(String.valueOf(movie.getYear()));

        Picasso.with(getContext())
                .load(movie.getPosters().getDetailed())
                .into(mPosterImageView);

    }
}
