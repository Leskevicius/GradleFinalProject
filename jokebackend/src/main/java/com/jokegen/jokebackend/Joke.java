package com.jokegen.jokebackend;

/**
 * The object model for the data we are sending through endpoints
 */
public class Joke {

    private String jokeContent;

    private String jokeAuthor;

    private String jokeDate;

    public String getJokeContent() {
        return jokeContent;
    }

    public void setJokeContent(String jokeContent) {
        this.jokeContent = jokeContent;
    }

    public String getJokeAuthor() {
        return jokeAuthor;
    }

    public void setJokeAuthor(String jokeAuthor) {
        this.jokeAuthor = jokeAuthor;
    }

    public String getJokeDate() {
        return jokeDate;
    }

    public void setJokeDate(String jokeDate) {
        this.jokeDate = jokeDate;
    }
}