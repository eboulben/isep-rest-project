package com.isep.javaeeproject.domain.repository.users;

import com.isep.javaeeproject.domain.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepositoryImpl extends AbstractRepository implements UsersRepository {

    @Override
    public List<String> getAllUsers() {
        return getEntityManager()
                .createQuery("SELECT author FROM TweetsEntity GROUP BY author", String.class)
                .getResultList();
    }
}
