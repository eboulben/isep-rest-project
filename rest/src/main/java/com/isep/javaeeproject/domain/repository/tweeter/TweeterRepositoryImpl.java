package com.isep.javaeeproject.domain.repository.tweeter;

import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;
import com.isep.javaeeproject.domain.repository.AbstractRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TweeterRepositoryImpl extends AbstractRepository implements TweeterRepository {

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
