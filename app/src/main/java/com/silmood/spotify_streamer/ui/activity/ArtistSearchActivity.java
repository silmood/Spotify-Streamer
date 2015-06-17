package com.silmood.spotify_streamer.ui.activity;

import android.view.Menu;
import android.view.MenuItem;

import com.silmood.spotify_streamer.R;
import com.silmood.spotify_streamer.SpotifyStreamerComponent;
import com.silmood.spotify_streamer.common.BaseActivity;
import com.silmood.spotify_streamer.common.BasePresenter;

/**
 * <p>
 *     The main activity, its due is provide a UI that allow the user to
 *     issue a search for an artist.
 * </p>
 * */
public class ArtistSearchActivity extends BaseActivity{

    @Override
    protected int getLayout() {
        return R.layout.activity_artist_search;

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void setUpComponent(SpotifyStreamerComponent appComponent) {
        //There isn't dependencies
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
