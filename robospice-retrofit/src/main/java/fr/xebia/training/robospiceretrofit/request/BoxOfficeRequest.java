package fr.xebia.training.robospiceretrofit.request;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;
import fr.xebia.training.robospiceretrofit.model.BoxOffice;
import fr.xebia.training.robospiceretrofit.service.MovieApi;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 05:40
 */
public class BoxOfficeRequest extends RetrofitSpiceRequest<BoxOffice, MovieApi>{

    public BoxOfficeRequest() {
        super(BoxOffice.class, MovieApi.class);
    }

    @Override
    public BoxOffice loadDataFromNetwork() throws Exception {
        return getService().listMovies();
    }
}
