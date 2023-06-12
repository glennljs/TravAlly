package com.alliance.travally.Database;

import org.springframework.stereotype.Service;

@Service
public class MockDatabaseService implements DatabaseService {

    @Override
    public <T> boolean create(T entity) {
        return true;
    }

    @Override
    public <T> T find(long id, Class<T> clazz) {
        return clazz.cast("hello");
    }

    @Override
    public <T> T update(T entity) {
        return entity;
    }

    @Override
    public void delete(long id) {

    }
}
