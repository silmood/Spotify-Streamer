package com.silmood.spotify_streamer.interactor;

import com.silmood.spotify_streamer.io.SpotifyApiService;
import com.silmood.spotify_streamer.io.callback.ArtistSearchServerCallback;
import com.silmood.spotify_streamer.io.model.ArtistSearchResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

    @Override
    public void performSearch(String query) {
        apiService.searchArtist(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ArtistSearchResponse>() {
                    @Override
                    public void call(ArtistSearchResponse artistSearchResponse) {
                        artistSearchResponse.getArtists();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }
}
