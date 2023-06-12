package com.alliance.travally.Database;

public interface DatabaseService {
    <T> boolean create(T entity);
    <T> T find(long id, Class<T> clazz);
    <T>  T update(T entity);
    void delete(long id);
}
