package com.silmood.spotify_streamer.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.silmood.spotify_streamer.R;
import com.silmood.spotify_streamer.SpotifyStreamerComponent;
import com.silmood.spotify_streamer.common.BaseFragment;
import com.silmood.spotify_streamer.common.BasePresenter;
import com.silmood.spotify_streamer.component.DaggerArtistSearchComponent;
import com.silmood.spotify_streamer.module.ArtistSearchModule;
import com.silmood.spotify_streamer.presenter.ArtistSearchPresenter;
import com.silmood.spotify_streamer.ui.adapter.SearchResultsAdapter;
import com.silmood.spotify_streamer.ui.modelview.ArtistSearchView;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by Pedro Antonio Hernández on 14/06/2015.
 *
 * <p>
 *     Provide a UI that allow the user to
 *     issue a search for an artist.
 * </p>
 */
public class ArtistSearchFragment extends BaseFragment implements ArtistSearchView{

    @Inject
    ArtistSearchPresenter mSearchPresenter;

    @Inject
    SearchResultsAdapter mResultsAdapter;

    @InjectView(R.id.etxt_search)
    EditText mArtistSearchInput;

    @InjectView(R.id.list_artist)
    RecyclerView mArtistResultsList;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_artist_search;
    }

    @Override
    protected BasePresenter getPresenter() {
        return mSearchPresenter;
    }

    @Override
    protected void setUpComponent(SpotifyStreamerComponent component) {
        DaggerArtistSearchComponent.builder()
                .spotifyStreamerComponent(component)
                .artistSearchModule(new ArtistSearchModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setupList() {
        mArtistResultsList.setLayoutManager(new LinearLayoutManager(CONTEXT));
        mArtistResultsList.setAdapter(mResultsAdapter);
    }

    @Override
    public void setupAdapter() {
        mResultsAdapter.setOnItemClickListener(mSearchPresenter);
    }

    @Override
    public void setupSearchInput() {
        mArtistSearchInput.addTextChangedListener(mSearchPresenter);
    }

    @Override
    public void resultsForArtistNotFound() {

    }

    @Override
    public void resultsForArtistFound() {

    }
}
