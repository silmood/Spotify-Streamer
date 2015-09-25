package com.silmood.spotify_streamer.interactor;

import com.silmood.spotify_streamer.io.SpotifyApiService;
import com.silmood.spotify_streamer.io.callback.ArtistSearchServerCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 */
public class ArtistSearchInteractor {

    SpotifyApiService apiService;

    public ArtistSearchInteractor(SpotifyApiService apiService) {
        this.apiService = apiService;
    }

  /*  public void performSearch(String query, final ArtistSearchServerCallback callback){
        apiService.searchArtist(query, new Callback<ArtistSearchResponse>() {
            @Override
            public void success(ArtistSearchResponse artistSearchResponse, Response response) {
                if (artistSearchResponse.getArtists().isEmpty())
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

    } */

    public void performSearch(String query, ArtistSearchServerCallback callback) {
        apiService.searchArtist(query)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(artistSearchResponse -> {callback.onArtistsFound(artistSearchResponse.getArtists());}
                        , throwable -> {callback.onFailedSearch();
                });
    }
}
