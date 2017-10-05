package com.jokelib;

/**
 * Created by on 10/4/17.
 */

public class Joke {

    private String content;
    private String author;
    private String date;

    public Joke() {}

    public Joke(String content, String author, String date) {
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
