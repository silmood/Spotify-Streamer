package com.silmood.spotify_streamer;

import android.content.Context;

import com.silmood.spotify_streamer.interactor.ArtistSearchInteractor;
import com.silmood.spotify_streamer.module.InteractorModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pedro Antonio Hernández on 12/06/2015.
 *
 * <p>
 *     The component due is provide methods that the object graph can use to inject dependencies.
 *     Its like an API for our object graph. <br>
 *
 *     Those methods inject objects created on corresponding modules.
 * </p>
 */

@Singleton
@Component(
        modules = {
                SpotifyStreamerModule.class,
                InteractorModule.class
        }
)
public interface SpotifyStreamerComponent {

    Context getContext();
    ArtistSearchInteractor getArtistSearchInteractor();
}
