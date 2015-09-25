package com.silmood.spotify_streamer.io;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Pedro Antonio Hernández on 16/06/2015.
 *
 * * This class contains the instance of the rest adapter to be connected with {@link SpotifyApiService}
 */
public class SpotifyApiAdapter {

    private static Retrofit RETROFIT;

    public static Retrofit getInstance(){
        //The adapter will be a singleton
        if(RETROFIT == null)
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(SpotifyApiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();


        return RETROFIT;
    }
}
