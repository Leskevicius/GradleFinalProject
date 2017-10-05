/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.jokegen.jokebackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.jokelib.JokeProvider;

/**
 * An endpoint class we are exposing
 */
@Api(
    name = "myApi",
    version = "v1",
    namespace = @ApiNamespace(
        ownerDomain = "jokebackend.jokegen.com",
        ownerName = "jokebackend.jokegen.com",
        packagePath = ""
    )
)
public class JokeEndpoint {

    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        Joke joke = new Joke();
        com.jokelib.Joke newJoke = JokeProvider.getJoke();
        joke.setJokeContent(newJoke.getContent());
        joke.setJokeAuthor(newJoke.getAuthor());
        joke.setJokeDate(newJoke.getDate());

        return joke;
    }
}
