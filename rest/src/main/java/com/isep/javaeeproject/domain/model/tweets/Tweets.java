package com.isep.javaeeproject.domain.model.tweets;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
public class Tweets implements Serializable {

    private static final long serialVersionUID = 4268044988849793635L;

    @XmlElement(name = "idTweets")
    private long idTweets;

    @XmlElement(name = "author")
    private String author;

    @XmlElement(name = "message")
    private String message;

    @XmlElement(name = "date")
    private Date date;

    public Tweets() {
    }

    public Tweets(long idTweets, String author, String message, Date date) {
        this.idTweets = idTweets;
        this.author = author;
        this.message = message;
        this.date = date;
    }

    public Tweets(TweetsEntity tweetsEntity) {
        this.idTweets = tweetsEntity.getIdTweets();
        this.author = tweetsEntity.getAuthor();
        this.message = tweetsEntity.getMessage();
        this.date = tweetsEntity.getDate();
    }

    public long getIdTweets() {
        return idTweets;
    }

    public void setIdTweets(long idTweets) {
        this.idTweets = idTweets;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweets)) return false;

        Tweets tweets = (Tweets) o;

        if (idTweets != tweets.idTweets) return false;
        if (!author.equals(tweets.author)) return false;
        if (!date.equals(tweets.date)) return false;
        if (!message.equals(tweets.message)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (idTweets ^ (idTweets >>> 32));
    }

    @Override
    public String toString() {
        return "Tweets{" +
                "idTweets=" + idTweets +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
