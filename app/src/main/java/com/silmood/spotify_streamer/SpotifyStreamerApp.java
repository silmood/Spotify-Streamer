package com.silmood.spotify_streamer;

import android.app.Application;
import android.content.Context;

/**
 * Created by Pedro Antonio Hernández on 12/06/2015.
 *
 *
 */
public class SpotifyStreamerApp extends Application {

    private SpotifyStreamerComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    /**
     * The object graph contains all the instances of the objects
     * that resolve a dependency
     * */
    private void setupGraph() {
        component = DaggerSpotifyStreamerComponent.builder()
                .spotifyStreamerModule(new SpotifyStreamerModule(this))
                .build();
    }

    public SpotifyStreamerComponent getComponent() {
        return component;
    }

    public static SpotifyStreamerApp getApp(Context context) {
        return (SpotifyStreamerApp) context.getApplicationContext();
    }
}
