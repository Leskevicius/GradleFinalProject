package com.jokegen.jokedisplay.cusomviews;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jokegen.jokedisplay.R;

/**
 * Custom Joke View. For all your laughing needs.
 */

public class JokeView extends LinearLayout {

    private TextView jokeContentView;
    private TextView jokeAuthorView;
    private TextView jokeDateView;

    public JokeView(Context context) {
        super(context);

        init(context, null);
    }

    public JokeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public JokeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        inflate(context, R.layout.joke_view_layout, this);

        jokeContentView = (TextView) findViewById(R.id.joke_content);
        jokeAuthorView = (TextView) findViewById(R.id.joke_author);
        jokeDateView = (TextView) findViewById(R.id.joke_date);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.JokeView,
                0, 0);

        try {
            final String jokeContent = a.getString(R.styleable.JokeView_jokeContent);
            final String jokeAuthor = a.getString(R.styleable.JokeView_jokeAuthor);
            final String jokeDate = a.getString(R.styleable.JokeView_jokeDate);

            setupTextView(jokeContentView, jokeContent);
            setupTextView(jokeAuthorView, jokeAuthor);
            setupTextView(jokeDateView, jokeDate);
        } finally {
            a.recycle();
        }
    }

    private void setupTextView(TextView textView, String text) {
        if (!TextUtils.isEmpty(text)) {
            textView.setText(text);
        }
    }

    /**
     * Sets the joke content.
     *
     * @param content {@link String}.
     */
    public void setJokeContent(String content) {
        jokeContentView.setText(content);
    }

    /**
     * Sets the jokes author.
     *
     *
     * @param author {@link String}.
     */
    public void setJokeAuthor(String author) {
        jokeAuthorView.setText(author);
    }

    /**
     * Sets the jokes date.
     *
     * @param date {@link String}.
     */
    public void setJokeDate(String date) {
        jokeDateView.setText(date);
    }

    /**
     * String representation of the joke content
     *
     * @return {@link String}.
     */
    public String getJokeContent() {
        return jokeContentView.getText().toString();
    }

    /**
     * String representation of the joke author
     *
     * @return {@link String}.
     */
    public String getJokeAuthor() {
        return jokeAuthorView.getText().toString();
    }

    /**
     * String representation of the joke date
     *
     * @return {@link String}.
     */
    public String getJokeDate() {
        return jokeDateView.getText().toString();
    }
}
