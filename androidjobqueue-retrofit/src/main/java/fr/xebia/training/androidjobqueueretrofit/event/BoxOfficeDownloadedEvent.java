package fr.xebia.training.androidjobqueueretrofit.event;

import fr.xebia.training.androidjobqueueretrofit.model.BoxOffice;

/**
 * User: mounirboudraa
 * Date: 13/02/2014
 * Time: 07:24
 */
public class BoxOfficeDownloadedEvent {

    public BoxOffice boxOffice;

    public BoxOfficeDownloadedEvent(BoxOffice boxOffice) {
        this.boxOffice = boxOffice;
    }
}
