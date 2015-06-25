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

package com.silmood.spotify_streamer.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.silmood.spotify_streamer.ui.adapter.TextWatcherAdapter;


/**
 * Created by Alex Yanchenko
 *
 * A modification of EditText class to have a such behavior of SearchView, this mean
 * when the user type something, a clear icon appear in the right side.
 *
 * */

/*I investigate a couple of resources and this class was the best to implement
* https://github.com/yanchenko/droidparts/blob/develop/droidparts/src/org/droidparts/widget/ClearableEditText.java
* */


public class ClearableEditText extends AppCompatEditText implements View.OnTouchListener,
        View.OnFocusChangeListener, TextWatcherAdapter.TextWatcherListener {

    public interface ClearListener {
        void didClearText();
    }

    /**
     * A custom interface to know when something has been type with almost three chars
     * */
    public interface QueryListener{
        int MIN_QUERY_LENGTH = 3;
        void onQueryChangeListener(String query);
    }

    public void setClearListener(ClearListener clearListener) {
        this.clearListener = clearListener;
    }

    public void setQueryListener(QueryListener queryListener) {
        this.queryListener = queryListener;
    }

    private Drawable xD;
    private ClearListener clearListener;
    private QueryListener queryListener;

    public ClearableEditText(Context context) {
        super(context);
        init();
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClearableEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        this.l = l;
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener f) {
        this.f = f;
    }

    private OnTouchListener l;
    private OnFocusChangeListener f;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //Check if the touch event was within clear icon coordinates
        if (getCompoundDrawables()[2] != null) {
            boolean tappedX = event.getX() > (getWidth() - getPaddingRight() - xD
                    .getIntrinsicWidth());
            if (tappedX) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    setText("");
                    if (clearListener != null) {
                        clearListener.didClearText();
                    }
                }
                return true;
            }
        }
        if (l != null) {
            return l.onTouch(v, event);
        }
        return false;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            setClearIconVisible(isNotEmpty(getText()));
        } else {
            setClearIconVisible(false);
        }
        if (f != null) {
            f.onFocusChange(v, hasFocus);
        }
    }

    @Override
    public void onTextChanged(EditText view, String text) {
        if (isFocused()) {
            setClearIconVisible(!text.isEmpty());
        }
    }

    @Override
    public void afterTextChanged(String text) {
        if (text.length() >= QueryListener.MIN_QUERY_LENGTH && queryListener != null){
            queryListener.onQueryChangeListener(text);
        }
    }

    private void init() {
        xD = getCompoundDrawables()[2];
        if (xD == null) {
            xD = getResources()
                    .getDrawable(android.R.drawable.presence_offline);
        }
        xD.setBounds(0, 0, xD.getIntrinsicWidth(), xD.getIntrinsicHeight());
        setClearIconVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(new TextWatcherAdapter(this, this));
    }

    protected void setClearIconVisible(boolean visible) {
        boolean wasVisible = (getCompoundDrawables()[2] != null);
        if (visible != wasVisible) {
            Drawable x = visible ? xD : null;
            setCompoundDrawables(getCompoundDrawables()[0],
                    getCompoundDrawables()[1], x, getCompoundDrawables()[3]);
        }
    }

    private boolean isNotEmpty(CharSequence text) {
        return !isEmpty(text);
    }

    private boolean isEmpty(CharSequence text) {
        return text == null || text.length() == 0;
    }

}