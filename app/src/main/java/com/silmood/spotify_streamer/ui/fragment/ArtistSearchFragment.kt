package com.silmood.spotify_streamer.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast

import com.silmood.spotify_streamer.R
import com.silmood.spotify_streamer.SpotifyStreamerApp
import com.silmood.spotify_streamer.common.BaseFragment
import com.silmood.spotify_streamer.common.BasePresenter
import com.silmood.spotify_streamer.component.DaggerArtistSearchComponent
import com.silmood.spotify_streamer.domain.Artist
import com.silmood.spotify_streamer.module.ArtistSearchModule
import com.silmood.spotify_streamer.presenter.ArtistSearchPresenter
import com.silmood.spotify_streamer.ui.adapter.SearchResultsAdapter
import com.silmood.spotify_streamer.ui.viewmodel.ArtistSearchView

import kotlinx.android.synthetic.main.fragment_artist_search.*

import java.util.ArrayList

import javax.inject.Inject



/**
 * Created by Pedro Antonio Hernández on 14/06/2015.

 *
 *
 * Provide a UI that allow the user to
 * issue a search for an artist.
 *
 */
class ArtistSearchFragment() : BaseFragment(), ArtistSearchView, SearchResultsAdapter.ItemClickListener {

    @Inject
    lateinit var mSearchPresenter: ArtistSearchPresenter

    @Inject
    lateinit var mResultsAdapter: SearchResultsAdapter

    override fun getFragmentLayout(): Int {
        return R.layout.fragment_artist_search
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        input_search.setQueryListener {
            query -> tryToSearchArtists(query)
        }

        list_artist.setHasFixedSize(true)
        list_artist.layoutManager = LinearLayoutManager(context)
        list_artist.adapter = mResultsAdapter

        mResultsAdapter.setOnItemClickListener(this)
    }

    override fun getPresenter(): BasePresenter {
        return mSearchPresenter
    }

    override fun injectDependencies () {
        super.injectDependencies()

        DaggerArtistSearchComponent
                .builder()
                .spotifyStreamerComponent(SpotifyStreamerApp.getApp(context).component)
                .artistSearchModule(ArtistSearchModule(this))
                .build()
                .inject(this)
    }

    fun tryToSearchArtists(query: CharSequence) {
        if (query.length >= 3)
            mSearchPresenter.searchArtists(query.toString())
        else if (query.length <= 2)
            mResultsAdapter.clear()
    }

    override fun displayFoundArtists(artists: ArrayList<Artist>) {
        mResultsAdapter.replace(artists)
    }

    override fun displayFailedSearch() {
        Toast.makeText(CONTEXT, R.string.failed_search, Toast.LENGTH_SHORT).show()
    }

    override fun displayNetworkError() {
        Toast.makeText(CONTEXT, R.string.network_error, Toast.LENGTH_SHORT).show()
    }

    override fun displayServerError() {
        Toast.makeText(CONTEXT, R.string.server_error, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(position: Int) {
        //Launch artist detail
    }

    companion object {
        val LOG_TAG = ArtistSearchFragment::class.java.simpleName
    }
}
