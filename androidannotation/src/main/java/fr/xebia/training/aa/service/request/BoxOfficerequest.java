package fr.xebia.training.aa.service.request;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;
import fr.xebia.training.aa.api.MovieApi;
import fr.xebia.training.aa.model.BoxOffice;
import org.androidannotations.annotations.EBean;

@EBean
public class BoxOfficeRequest extends RetrofitSpiceRequest<BoxOffice, MovieApi> {

    public BoxOfficeRequest() {
        super(BoxOffice.class, MovieApi.class);
    }

    @Override
    public BoxOffice loadDataFromNetwork() throws Exception {
        BoxOffice  boxOffice = getService().listMovies();
        return boxOffice;
    }
}
