package com.silmood.spotify_streamer;

import android.content.Context;

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
                SpotifyStreamerModule.class
        }
)
public interface SpotifyStreamerComponent {

    void inject (SpotifyStreamerApp app);

    Context getContext();
}
