package mx.dgtic.dao;

import java.util.List;

// CRUD Learnhub
public interface LearnHubDao<T> {
    void insert(T obj);
    void update(T obj);
    void delete(T obj);
    T findById(Object id);
    List<T> findAll();
}
