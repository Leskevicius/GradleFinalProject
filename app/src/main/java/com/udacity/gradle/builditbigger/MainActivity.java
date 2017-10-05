package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jokegen.jokebackend.myApi.model.Joke;
import com.jokegen.jokedisplay.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity implements JokeEndpointAsyncTask.JokeListener {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new JokeEndpointAsyncTask().execute(this);
        showProgressBar(true);
    }


    @Override
    public void onComplete(Joke joke) {
        showProgressBar(false);
        if (joke != null) {
            launchJokeActivity(joke);
        }
    }

    private void launchJokeActivity(Joke joke) {
        Toast.makeText(this, joke.getJokeContent(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.JOKE_CONTENT, joke.getJokeContent());
        intent.putExtra(JokeDisplayActivity.JOKE_AUTHOR, joke.getJokeAuthor());
        intent.putExtra(JokeDisplayActivity.JOKE_DATE, joke.getJokeDate());
        startActivity(intent);
    }

    private void showProgressBar(boolean show) {
        mProgressBar.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }
}
