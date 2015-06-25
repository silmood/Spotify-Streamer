/**
 * Copyright 2015 Alex Yanchenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.silmood.spotify_streamer.ui.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.silmood.spotify_streamer.ui.view.ClearableEditText;


/**
 * Created by Alex Yanchenko
 *
 * A simplified TextWatcher that helps to {@link ClearableEditText} to know when text is changing.
 * */
public class TextWatcherAdapter implements TextWatcher {

    public interface TextWatcherListener {

        void onTextChanged(EditText view, String text);
        void afterTextChanged(String text);
    }

    private final EditText view;
    private final TextWatcherListener listener;

    public TextWatcherAdapter(EditText editText, TextWatcherListener listener) {
        this.view = editText;
        this.listener = listener;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        listener.onTextChanged(view, s.toString());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // pass
    }

    @Override
    public void afterTextChanged(Editable s) {
        listener.afterTextChanged(s.toString());
    }

}