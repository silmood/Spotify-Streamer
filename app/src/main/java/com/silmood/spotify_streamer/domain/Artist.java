package com.silmood.spotify_streamer.domain;

import android.support.annotation.Nullable;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 */
public class Artist {

    String name;

    @Nullable
    String urlImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
