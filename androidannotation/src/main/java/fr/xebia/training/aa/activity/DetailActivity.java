package fr.xebia.training.aa.activity;

import android.app.Activity;
import android.app.FragmentManager;
import fr.xebia.training.aa.R;
import fr.xebia.training.aa.fragment.DetailFragment;
import fr.xebia.training.aa.fragment.DetailFragment_;
import fr.xebia.training.aa.model.Movie;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;


@EActivity(R.layout.activity_detail)
public class DetailActivity extends Activity {


    @Extra("movie")
    Movie mMovie;

    DetailFragment mDetailFragment;

    @AfterViews
    void afterActivityCreated() {

        FragmentManager fm = getFragmentManager();
        mDetailFragment = (DetailFragment) fm.findFragmentByTag(DetailFragment.class.getName());

        if (mDetailFragment == null) {
            mDetailFragment = DetailFragment_.builder()
                    .mMovie(mMovie)
                    .build();
        }

        fm.beginTransaction()
                .replace(R.id.detail_container, mDetailFragment, DetailFragment.class.getName())
                .commit();

    }




}
