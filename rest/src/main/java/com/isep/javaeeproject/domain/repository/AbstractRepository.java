package com.isep.javaeeproject.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository {

    @PersistenceContext(unitName = "restPersistenceUnit")
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
