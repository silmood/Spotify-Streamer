package com.silmood.spotify_streamer.module;

import android.content.Context;

import com.silmood.spotify_streamer.component.ArtistSearchComponent;
import com.silmood.spotify_streamer.interactor.ArtistSearchInteractor;
import com.silmood.spotify_streamer.presenter.ArtistSearchPresenter;
import com.silmood.spotify_streamer.ui.activity.ArtistSearchActivity;
import com.silmood.spotify_streamer.ui.adapter.SearchResultsAdapter;
import com.silmood.spotify_streamer.ui.viewmodel.ArtistSearchView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 * This module create the object instances for {@link ArtistSearchActivity}.
 * The instances will be injected trough methods declared in {@link ArtistSearchComponent}
 */

@Module
public class ArtistSearchModule {

    private ArtistSearchView view;

    public ArtistSearchModule(ArtistSearchView view) {
        this.view = view;
    }

    @Provides
    public ArtistSearchView provideView() {
        return view;
    }

    @Provides
    public ArtistSearchPresenter providePresenter(ArtistSearchView view, ArtistSearchInteractor interactor) {
        return new ArtistSearchPresenter(view, interactor);
    }

    @Provides
    public SearchResultsAdapter provideAdapter(Context context) {
        return new SearchResultsAdapter(context);
    }
}
