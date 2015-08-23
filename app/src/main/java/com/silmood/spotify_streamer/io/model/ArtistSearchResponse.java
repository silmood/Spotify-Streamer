package com.silmood.spotify_streamer.io.model;

import com.google.gson.annotations.SerializedName;
import com.silmood.spotify_streamer.domain.Artist;

import java.util.ArrayList;

/**
 * Created by Pedro Antonio Hernández on 16/06/2015.
 *
 * A simple model to parse with {@link com.google.gson.Gson}
 */
public class ArtistSearchResponse {

    @SerializedName("artists")
    ArtistsResponse artistsResponse;

    public ArrayList<Artist> getArtists() {
        return artistsResponse.artists;
    }

    private class ArtistsResponse {
        @SerializedName("items")
        ArrayList<Artist> artists;
    }
}
