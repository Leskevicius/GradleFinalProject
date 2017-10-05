package com.jokegen.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jokegen.jokedisplay.cusomviews.JokeView;

public class JokeDisplayActivity extends AppCompatActivity {

    public final static String JOKE_CONTENT = "jokeContent";
    public final static String JOKE_AUTHOR = "jokeAuthor";
    public final static String JOKE_DATE = "jokeDate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        JokeView jokeView = (JokeView) findViewById(R.id.joke_view);

        Bundle extras = getIntent().getExtras();
        String jokeContent = extras.getString(JOKE_CONTENT);
        String jokeAuthor = extras.getString(JOKE_AUTHOR);
        String jokeDate = extras.getString(JOKE_DATE);

        jokeView.setJokeContent(jokeContent);
        jokeView.setJokeAuthor(jokeAuthor);
        jokeView.setJokeDate(jokeDate);
    }
}
