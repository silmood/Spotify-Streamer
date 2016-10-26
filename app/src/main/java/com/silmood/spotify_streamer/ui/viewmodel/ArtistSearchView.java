package com.silmood.spotify_streamer.ui.viewmodel;

import com.silmood.spotify_streamer.domain.Artist;
import com.silmood.spotify_streamer.ui.activity.ArtistSearchActivity;

import java.util.ArrayList;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 * <p>
 * Model for every UI operations that could occur in {@link ArtistSearchActivity}
 * </p>
 */
public interface ArtistSearchView {

    void displayFoundArtists(ArrayList<Artist> artists);

    void displayFailedSearch();

    void displayNetworkError();

    void displayServerError();
}
