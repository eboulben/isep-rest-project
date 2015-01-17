package com.isep.javaeeproject.domain.model.users;

import com.isep.javaeeproject.domain.model.tweets.Tweets;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Users implements Serializable {

    private static final long serialVersionUID = 7435192782653436987L;

    @XmlElement(name = "idAuthor")
    private long idAuthor;

    @XmlElement(name = "author")
    private String author;

    public Users(){
    }

    public Users(long idAuthor, String author) {
        this.idAuthor = idAuthor;
        this.author = author;
    }

    public Users(Tweets tweet) {
        this.idAuthor = tweet.getIdAuthor();
        this.author = tweet.getAuthor();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        if (idAuthor != users.idAuthor) return false;
        if (!author.equals(users.author)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idAuthor ^ (idAuthor >>> 32));
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idAuthor=" + idAuthor +
                ", author='" + author + '\'' +
                '}';
    }
}
