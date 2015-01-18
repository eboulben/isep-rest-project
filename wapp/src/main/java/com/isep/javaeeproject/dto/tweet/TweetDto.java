package com.isep.javaeeproject.dto.tweet;

public class TweetDto {
    private String message;
    private String date;
    private String authorName;

    public TweetDto(String message, String date, String authorName) {
        this.message = message;
        this.date = date;
        this.authorName = authorName;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
