package com.silmood.spotify_streamer.module;

import com.silmood.spotify_streamer.SpotifyStreamerComponent;
import com.silmood.spotify_streamer.interactor.ArtistSearchInteractor;
import com.silmood.spotify_streamer.io.SpotifyApiService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 *<p>
 *     This module create the interactors instances. The instances will be injected trough methods
 *     declared in {@link SpotifyStreamerComponent}
 *</p>
 */

@Module
public class InteractorModule {

    @Provides
    public ArtistSearchInteractor provideArtistSearchInteractor(SpotifyApiService apiService){
        return new ArtistSearchInteractor(apiService);
    }

}
