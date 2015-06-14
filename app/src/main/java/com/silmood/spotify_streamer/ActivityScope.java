package com.silmood.spotify_streamer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Pedro Antonio Hernández López on 08/05/2015.
 *
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}