package com.silmood.spotify_streamer.interactor;

import com.silmood.spotify_streamer.io.SpotifyApiService;
import com.silmood.spotify_streamer.io.callback.ArtistSearchServerCallback;
import com.silmood.spotify_streamer.io.model.ArtistSearchResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 * {@link ArtistSearchInteractor} implementation
 */
public class ArtistSearchInteractorImpl implements ArtistSearchInteractor {

    SpotifyApiService apiService;

    public ArtistSearchInteractorImpl(SpotifyApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void performSearch(String query, final ArtistSearchServerCallback callback){
        apiService.searchArtist(query, new Callback<ArtistSearchResponse>() {
            @Override
            public void success(ArtistSearchResponse artistSearchResponse, Response response) {
                if(artistSearchResponse.getArtists().isEmpty())
                    callback.onFailedSearch();

                else
                    callback.onArtistsFound(artistSearchResponse.getArtists());
            }

            @Override
            public void failure(RetrofitError error) {
                if (error.getKind() == RetrofitError.Kind.NETWORK)
                    callback.onNetworkError(error);

                else
                    callback.onServerError(error);
            }
        });
    }
}
