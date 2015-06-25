package com.silmood.spotify_streamer.io;

/**
 * Created by Pedro Antonio Hernández on 16/06/2015.
 *
 * Constants used for requests to API
 */
public class SpotifyApiConstants {

    public static final String BASE_URL = "https://api.spotify.com";

    public static final String VERSION_PATH = "/v1";
    public static final String SEARCH_PATH = "/search";

    public static final String TYPE_QUERY = "type";
    public static final String QUERY_TO_SEARCH = "q";

    public static final String ARTIST = "artist";

    public static final String ARTIST_SEARCH_URL = VERSION_PATH + SEARCH_PATH + "?"+ TYPE_QUERY + "=" + ARTIST;
}
