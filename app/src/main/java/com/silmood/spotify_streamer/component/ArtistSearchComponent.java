package com.silmood.spotify_streamer.component;

import com.silmood.spotify_streamer.SpotifyStreamerComponent;
import com.silmood.spotify_streamer.common.ActivityScope;
import com.silmood.spotify_streamer.module.ArtistSearchModule;
import com.silmood.spotify_streamer.presenter.ArtistSearchPresenter;
import com.silmood.spotify_streamer.ui.activity.ArtistSearchActivity;
import com.silmood.spotify_streamer.ui.adapter.SearchResultsAdapter;
import com.silmood.spotify_streamer.ui.fragment.ArtistSearchFragment;

import dagger.Component;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 * <p>
 *     Methods to inject dependencies into {@link ArtistSearchActivity}
 * </p>
 */

@ActivityScope
@Component(
        dependencies = SpotifyStreamerComponent.class,
        modules = ArtistSearchModule.class
)
public interface ArtistSearchComponent {

    void inject(ArtistSearchFragment searchFragment);

    ArtistSearchPresenter getPresenter();
    SearchResultsAdapter getAdapter();
}
