package com.isep.javaeeproject.domain.repository.tweets;

import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;
import com.isep.javaeeproject.domain.repository.AbstractRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class TweetsRepositoryImpl extends AbstractRepository implements TweetsRepository {

    @Override
    public List<TweetsEntity> getAllTweets() {
        return getEntityManager().createQuery("FROM TweetsEntity ", TweetsEntity.class).getResultList();
    }

    @Override
    public TweetsEntity getTweet(final long id) throws NoResultException {
        return getEntityManager()
                .createQuery("FROM TweetsEntity T WHERE T.idTweets = :paramId", TweetsEntity.class)
                .setParameter("paramId", id).getSingleResult();
    }

    @Override
    public List<TweetsEntity> getTweetForUser(final String user) {
        return getEntityManager()
                .createQuery("FROM TweetsEntity T WHERE T.author = :nameUser", TweetsEntity.class)
                .setParameter("nameUser", user).getResultList();
    }

    @Override
    public void purge() {
        getEntityManager().createQuery("DELETE FROM TweetsEntity ").executeUpdate();
    }

    @Override
    public void insert(List<TweetsEntity> tweets) {
        final Session session = getEntityManager().unwrap(Session.class);
        tweets.forEach(session::save);
    }
}
