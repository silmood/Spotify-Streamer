package com.silmood.spotify_streamer.presenter;

import com.silmood.spotify_streamer.common.BasePresenter;
import com.silmood.spotify_streamer.interactor.ArtistSearchInteractor;
import com.silmood.spotify_streamer.ui.adapter.SearchResultsAdapter;
import com.silmood.spotify_streamer.ui.modelview.ArtistSearchView;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 */
public class ArtistSearchPresenter extends BasePresenter implements SearchResultsAdapter.ItemClickListener{

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

    @Override
    public void onItemClicked(int position) {

    }
}
