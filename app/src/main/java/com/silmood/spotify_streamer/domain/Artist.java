package com.silmood.spotify_streamer.domain;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.silmood.spotify_streamer.io.model.Constants;

import java.util.Arrays;

/**
 * Created by Pedro Antonio Hernández on 13/06/2015.
 *
 */
public class Artist {

    String name;

    @SerializedName(Constants.IMAGES)
    @Nullable
    SpotifyImage[] urlImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpotifyImage[] getUrlsImage() {
        return urlImage;
    }

    public void setUrlsImage(SpotifyImage[] urlImage) {
        this.urlImage = urlImage;
    }

    @Nullable
    public SpotifyImage getMediumImage() {
        assert urlImage != null;
        if (urlImage.length >= 2) {
            return urlImage[1];
        }

        return null;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", urlImage='" + Arrays.toString(urlImage) + '\'' +
                '}';
    }
}
