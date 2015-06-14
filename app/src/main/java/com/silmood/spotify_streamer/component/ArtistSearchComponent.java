package com.silmood.spotify_streamer.component;

import com.silmood.spotify_streamer.ActivityScope;
import com.silmood.spotify_streamer.module.ArtistSearchModule;
import com.silmood.spotify_streamer.presenter.ArtistSearchPresenter;
import com.silmood.spotify_streamer.ui.activity.ArtistSearchActivity;

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
        modules = ArtistSearchModule.class
)
public interface ArtistSearchComponent {

    void inject(ArtistSearchActivity searchActivity);

    ArtistSearchPresenter getPresenter();
}
