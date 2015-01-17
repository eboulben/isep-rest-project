package com.isep.javaeeproject.domain.model.tweets;

import org.springframework.beans.BeanUtils;

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
    @Column(nullable = false, name = "id_author")
    private long idAuthor;

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

    public TweetsEntity(long idTweets, long idAuthor, String author, String message, Date date) {
        this.idTweets = idTweets;
        this.idAuthor = idAuthor;
        this.author = author;
        this.message = message;
        this.date = date;
    }

    public TweetsEntity(Tweets tweets) {
        BeanUtils.copyProperties(this, tweets);
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TweetsEntity)) return false;

        TweetsEntity that = (TweetsEntity) o;

        return idAuthor == that.idAuthor &&
                idTweets == that.idTweets &&
                author.equals(that.author) &&
                date.equals(that.date) &&
                message.equals(that.message);
    }

    @Override
    public int hashCode() {
        int result = (int) (idTweets ^ (idTweets >>> 32));
        result = 31 * result + (int) (idAuthor ^ (idAuthor >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TweetsEntity{" +
                "id=" + id +
                ", idTweets=" + idTweets +
                ", idAuthor=" + idAuthor +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
