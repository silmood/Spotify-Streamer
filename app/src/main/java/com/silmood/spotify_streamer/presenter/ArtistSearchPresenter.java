package com.silmood.spotify_streamer.presenter;

import com.silmood.spotify_streamer.common.BasePresenter;
import com.silmood.spotify_streamer.domain.Artist;
import com.silmood.spotify_streamer.interactor.ArtistSearchInteractor;
import com.silmood.spotify_streamer.io.callback.ArtistSearchServerCallback;
import com.silmood.spotify_streamer.ui.viewmodel.ArtistSearchView;

import java.util.ArrayList;

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
    public void onNetworkError() {
        searchView.displayNetworkError();
    }

    @Override
    public void onServerError() {
        searchView.displayServerError();
    }
}
