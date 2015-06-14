package com.silmood.spotify_streamer.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.silmood.spotify_streamer.SpotifyStreamerApp;
import com.silmood.spotify_streamer.SpotifyStreamerComponent;

import butterknife.ButterKnife;

/**
 * Created by Pedro Antonio Hernández on 12/06/2015.
 *
 *<p>
 * The activity only will execute operations that affect the UI. These operations are defined
 * by its view model and are triggered by its presenter.
 *</p>
 *
 * <p>
 * I made some modifications to the BaseActivity presented in the next project.
 * I implement Dagger 2 instead Dagger 1 and i attach the presenter directly
 * <a href="https://github.com/pedrovgs/EffectiveAndroidUI">EffectiveAndroidUI</a>
 * </p>
 */
public abstract class BaseActivity extends AppCompatActivity{

    /**
     * The onCreate base will set the view specified in {@link #getLayout()} and will
     * inject dependencies and views.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        injectDependencies();
        injectViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().onStop();
    }

    /**
     * @return The layout that's gonna be the activity view.
     * */
    protected abstract int getLayout();

    /**
     * @return The presenter attached to the activity. This must extends from {@link BasePresenter}
     * */
    protected abstract BasePresenter getPresenter();

    /**
     * Setup the object graph and inject the dependencies needed on this activity.
     * */
    private void injectDependencies() {
        setUpComponent(SpotifyStreamerApp.getApp(this).getComponent());
    }

    /**
     * Every object annotated with {@link butterknife.InjectView} its gonna injected trough butterknife
     * */
    private void injectViews() {
        ButterKnife.inject(this);
    }


    public abstract void setUpComponent(SpotifyStreamerComponent appComponent);
}

