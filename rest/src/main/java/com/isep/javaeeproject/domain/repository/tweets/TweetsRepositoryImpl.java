package com.isep.javaeeproject.domain.repository.tweets;

import com.isep.javaeeproject.domain.model.tweets.TweetsEntity;
import com.isep.javaeeproject.domain.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TweetsRepositoryImpl extends AbstractRepository implements TweetsRepository {

    @Override
    public List<TweetsEntity> getAllTweets() {
        return getEntityManager().createQuery("FROM TweetsEntity ", TweetsEntity.class).getResultList();
    }

    @Override
    public TweetsEntity getTweet(long id) {
        return null;
    }
}
