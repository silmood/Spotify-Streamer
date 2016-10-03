package com.silmood.spotify_streamer;

import android.app.Application;
import android.content.Context;

import com.silmood.spotify_streamer.io.SpotifyApiAdapter;
import com.silmood.spotify_streamer.io.SpotifyApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * The module due is create objects to solve dependencies
 * trough methods annotated with {@link dagger.Provides} annotation.
 *<p>
 * I use a Module based on this
 * <a href="http://frogermcs.github.io/dagger-1-to-2-migration/">tutorial</a>
 *</p>
 */

@Module
public class SpotifyStreamerModule {

    private SpotifyStreamerApp app;

    public SpotifyStreamerModule (SpotifyStreamerApp app) {
        this.app = app;
    }

    @Provides @Singleton public Application provideApplication() {
        return app;
    }

    @Provides @Singleton public Context provideContext() {
        return app;
    }

    @Provides @Singleton public Retrofit provideRetrofitInstance() {
        return SpotifyApiAdapter.getInstance();
    }

    @Provides @Singleton public SpotifyApiService provideSpotifyApiService(Retrofit retrofit){
        return retrofit.create(SpotifyApiService.class);
    }

}
