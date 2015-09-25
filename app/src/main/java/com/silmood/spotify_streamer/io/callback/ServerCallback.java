package com.silmood.spotify_streamer.io.callback;


/**
 * Created by Pedro Antonio Hernández on 21/06/2015.
 *
 * To simplified the communication between interactor and presenter will be custom callbacks that contains
 * only data needed from presenter.
 *
 *
 */
public interface ServerCallback {
    void onNetworkError();

    void onServerError();
}
