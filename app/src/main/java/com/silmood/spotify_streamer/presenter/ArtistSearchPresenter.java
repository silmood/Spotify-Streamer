package com.silmood.spotify_streamer.presenter;

import android.util.Log;

import com.silmood.spotify_streamer.common.BasePresenter;
import com.silmood.spotify_streamer.domain.Artist;
import com.silmood.spotify_streamer.interactor.ArtistSearchInteractor;
import com.silmood.spotify_streamer.io.callback.ArtistSearchServerCallback;
import com.silmood.spotify_streamer.ui.adapter.SearchResultsAdapter;
import com.silmood.spotify_streamer.ui.viewmodel.ArtistSearchView;
import com.silmood.spotify_streamer.ui.view.ClearableEditText;

import java.util.ArrayList;

import retrofit.RetrofitError;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 */
public class ArtistSearchPresenter extends BasePresenter implements ArtistSearchServerCallback {
    public static final String LOG_TAG = ArtistSearchPresenter.class.getSimpleName();

    ArtistSearchView searchView;
    ArtistSearchInteractor searchInteractor;

    public ArtistSearchPresenter(ArtistSearchView view, ArtistSearchInteractor interactor) {
        searchView = view;
        searchInteractor = interactor;
    }

    @Override
    public void onStart() {
        searchView.setupAdapter();
        searchView.setupList();
    }

    @Override
    public void onStop() {

    }


    public void searchArtists(String query) {
        searchInteractor.performSearch(query, this);
    }

    @Override
    public void onArtistsFound(ArrayList<Artist> artists) {
        searchView.displayFoundArtists(artists);
    }

    @Override
    public void onFailedSearch() {
        searchView.displayFailedSearch();
    }

    @Override
    public void onNetworkError(RetrofitError error) {
        error.printStackTrace();
        searchView.displayNetworkError();
    }

    @Override
    public void onServerError(RetrofitError error) {
        error.printStackTrace();
        searchView.displayServerError();
    }
}
