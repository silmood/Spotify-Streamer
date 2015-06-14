package com.silmood.spotify_streamer.ui.activity;

import android.view.Menu;
import android.view.MenuItem;

import com.silmood.spotify_streamer.R;
import com.silmood.spotify_streamer.SpotifyStreamerComponent;
import com.silmood.spotify_streamer.common.BaseActivity;
import com.silmood.spotify_streamer.common.BasePresenter;
import com.silmood.spotify_streamer.ui.modelview.ArtistSearchView;


public class ArtistSearchActivity extends BaseActivity implements ArtistSearchView {

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void setUpComponent(SpotifyStreamerComponent appComponent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setupList() {

    }

    @Override
    public void resultsForArtistNotFound() {

    }

    @Override
    public void resultsForArtistFound() {

    }
}
