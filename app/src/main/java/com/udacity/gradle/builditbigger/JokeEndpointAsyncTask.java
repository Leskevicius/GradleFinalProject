package com.udacity.gradle.builditbigger;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.jokegen.jokebackend.myApi.MyApi;
import com.jokegen.jokebackend.myApi.model.Joke;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

/**
 * Created by on 10/4/17.
 */

class JokeEndpointAsyncTask extends AsyncTask<JokeEndpointAsyncTask.JokeListener, Void, Joke> {
    private final static String TAG = JokeEndpointAsyncTask.class.getCanonicalName();
    private static MyApi myApiService = null;
    private JokeListener listener;

    @Override
    protected Joke doInBackground(JokeEndpointAsyncTask.JokeListener... params) {
//        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                new AndroidJsonFactory(), null)
//                // options for running against local devappserver
//                // - 10.0.2.2 is localhost's IP address in Android emulator
//                // - turn off compression when running against local devappserver
//                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                    @Override
//                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                        abstractGoogleClientRequest.setDisableGZipContent(true);
//                    }
//                });
//            // end options for devappserver
//
//            myApiService = builder.build();
//        }
//
//        listener = params[0];

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokebackend-182419.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        listener = params[0];

        try {
            return myApiService.getJoke().execute();
        } catch (IOException e) {
            Log.w(TAG, "API didn't get the joke. /s");
            return null;
        }
    }

    @Override
    protected void onPostExecute(Joke result) {
        listener.onComplete(result);
    }

    public interface JokeListener {
        void onComplete(Joke joke);
    }
}
