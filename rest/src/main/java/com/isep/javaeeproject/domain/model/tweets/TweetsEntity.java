package com.isep.javaeeproject.domain.model.tweets;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tweets")
public class TweetsEntity implements Serializable {

    private static final long serialVersionUID = 6706182821784345096L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(nullable = false, name = "id_tweets")
    private long idTweets;

    @NotNull
    @Size(max = 50)
    @Column(length = 50, nullable = false, name = "author")
    private String author;

    @NotNull
    @Size(max = 250)
    @Column(length = 250, nullable = false, name = "message")
    private String message;

    @NotNull
    @Column(name = "date")
    private Date date;

    public TweetsEntity() {
    }

    public TweetsEntity(long idTweets, String author, String message, Date date) {
        this.idTweets = idTweets;
        this.author = author;
        this.message = message;
        this.date = date;
    }

    public TweetsEntity(Tweets tweets) {
        this.idTweets = tweets.getIdTweets();
        this.author = tweets.getAuthor();
        this.message = tweets.getMessage();
        this.date = tweets.getDate();
    }

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "id_tweets")
    public long getIdTweets() {
        return idTweets;
    }

    public void setIdTweets(long idTweets) {
        this.idTweets = idTweets;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TweetsEntity)) return false;

        TweetsEntity that = (TweetsEntity) o;

        if (id != that.id) return false;
        if (idTweets != that.idTweets) return false;
        if (!author.equals(that.author)) return false;
        if (!date.equals(that.date)) return false;
        if (!message.equals(that.message)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (idTweets ^ (idTweets >>> 32));
    }

    @Override
    public String toString() {
        return "TweetsEntity{" +
                "id=" + id +
                ", idTweets=" + idTweets +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
