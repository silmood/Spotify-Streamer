package com.silmood.spotify_streamer.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.silmood.spotify_streamer.R;
import com.silmood.spotify_streamer.SpotifyStreamerComponent;
import com.silmood.spotify_streamer.common.BaseActivity;
import com.silmood.spotify_streamer.common.BasePresenter;
import com.silmood.spotify_streamer.presenter.ArtistSearchPresenter;
import com.silmood.spotify_streamer.ui.adapter.SearchResultsAdapter;
import com.silmood.spotify_streamer.ui.modelview.ArtistSearchView;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * <p>
 *     The main activity, its due is provide a UI that allow the user to
 *     issue a search for an artist.
 * </p>
 * */
public class ArtistSearchActivity extends BaseActivity implements ArtistSearchView {

    @Inject
    ArtistSearchPresenter mSearchPresenter;

    @Inject
    SearchResultsAdapter mResultsAdapter;

    @InjectView(R.id.etxt_search)
    EditText mArtistSearchInput;

    @InjectView(R.id.list_artist)
    RecyclerView mArtistResultsList;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;

    }

    @Override
    protected BasePresenter getPresenter() {
        return mSearchPresenter;
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
        mArtistResultsList.setLayoutManager(new LinearLayoutManager(this));
        mArtistResultsList.setAdapter(mResultsAdapter);
    }

    @Override
    public void setupAdapter() {
        mResultsAdapter.setOnItemClickListener(mSearchPresenter);
    }

    @Override
    public void resultsForArtistNotFound() {

    }

    @Override
    public void resultsForArtistFound() {

    }
}
