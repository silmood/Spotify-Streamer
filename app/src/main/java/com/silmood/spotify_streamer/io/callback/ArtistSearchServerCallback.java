package com.silmood.spotify_streamer.io.callback;

import com.silmood.spotify_streamer.domain.Artist;
import com.silmood.spotify_streamer.presenter.ArtistSearchPresenter;

import java.util.ArrayList;

/**
 * Created by Pedro Antonio Hernández on 21/06/2015.
 *
 * Main callback to communicate search results to {@link ArtistSearchPresenter}
 */
public interface ArtistSearchServerCallback extends ServerCallback {

    void onArtistsFound(ArrayList<Artist> artists);

    void onFailedSearch();
}
