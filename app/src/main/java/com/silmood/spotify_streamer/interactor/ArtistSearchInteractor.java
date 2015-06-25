package com.silmood.spotify_streamer.interactor;

import com.silmood.spotify_streamer.io.callback.ArtistSearchServerCallback;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 */
public interface ArtistSearchInteractor {

    void performSearch(String query, ArtistSearchServerCallback callback);
}
