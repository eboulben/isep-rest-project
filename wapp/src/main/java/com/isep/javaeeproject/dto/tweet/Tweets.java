package com.isep.javaeeproject.dto.tweet;

import java.util.Date;

public class Tweets {

    private long idTweets;

    private long idAuthor;

    private String author;

    private String message;

    private Date date;

    public Tweets() {
    }

    public Tweets(long idTweets, long idAuthor, String author, String message, Date date) {
        this.idTweets = idTweets;
        this.idAuthor = idAuthor;
        this.author = author;
        this.message = message;
        this.date = date;
    }

    public long getIdTweets() {
        return idTweets;
    }

    public void setIdTweets(long idTweets) {
        this.idTweets = idTweets;
    }

    public long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tweets{" +
                "idTweets=" + idTweets +
                ", idAuthor=" + idAuthor +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
