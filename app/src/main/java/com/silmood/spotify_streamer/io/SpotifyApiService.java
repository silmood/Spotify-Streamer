package com.silmood.spotify_streamer.io;

import com.silmood.spotify_streamer.io.model.ArtistSearchResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Pedro Antonio Hernández on 16/06/2015.
 *
 * All methods that will make a request to Spotify API
 */
public interface SpotifyApiService {

    @GET(SpotifyApiConstants.ARTIST_SEARCH_URL)
    Observable<ArtistSearchResponse> searchArtist(@Query(SpotifyApiConstants.QUERY_TO_SEARCH) String query);
}
