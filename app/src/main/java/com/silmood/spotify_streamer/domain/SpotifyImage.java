package com.silmood.spotify_streamer.domain;

import com.google.gson.annotations.SerializedName;
import com.silmood.spotify_streamer.io.model.Constants;

/**
 * Created by Pedro Antonio Hernández on 17/06/2015.
 *
 */
public class SpotifyImage {

    @SerializedName(Constants.WIDTH)
    int width;

    @SerializedName(Constants.HEIGHT)
    int height;

    @SerializedName(Constants.URL)
    String url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SpotifyImage{" +
                "width=" + width +
                ", height=" + height +
                ", url='" + url + '\'' +
                '}';
    }
}
