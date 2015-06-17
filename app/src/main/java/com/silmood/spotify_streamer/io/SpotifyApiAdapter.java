package com.silmood.spotify_streamer.io;

import retrofit.RestAdapter;

/**
 * Created by Pedro Antonio Hernández on 16/06/2015.
 *
 * * This class contains the instance of the rest adapter to be connected with {@link SpotifyApiService}
 */
public class SpotifyApiAdapter {

    private static RestAdapter API_ADAPTER;

    public static RestAdapter getInstance(){
        //The adapter will be a singleton
        if(API_ADAPTER == null)
            API_ADAPTER = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setEndpoint(SpotifyApiConstants.BASE_URL)
                    .build();


        return API_ADAPTER;
    }
}
