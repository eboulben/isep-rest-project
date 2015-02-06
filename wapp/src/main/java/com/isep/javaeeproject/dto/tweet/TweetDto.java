package com.isep.javaeeproject.dto.tweet;

import java.util.Date;

public class TweetDto {

    private long idTweets;
    private String message;
    private Date date;
    private String author;

    public TweetDto(long idTweets, String author, String message, Date date) {
        this.idTweets = idTweets;
        this.message = message;
        this.date = date;
        this.author = author;
    }

    public long getIdTweets() {
        return idTweets;
    }

    public void setIdTweets(long idTweets) {
        this.idTweets = idTweets;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "TweetDto{" +
                "idTweets=" + idTweets +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                '}';
    }
}
