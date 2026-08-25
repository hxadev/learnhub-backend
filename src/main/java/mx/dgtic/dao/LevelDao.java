package mx.dgtic.dao;

import jakarta.persistence.EntityManager;
import mx.dgtic.entity.Level;
import mx.dgtic.utils.HibernateUtil;

import java.util.List;

public class LevelDao implements LearnHubDao<Level> {
    protected EntityManager entityManager;

    public LevelDao() {
        entityManager = HibernateUtil.getInstance().createEntityManager();
    }

    @Override
    public void insert(Level obj) {

    }

    @Override
    public void update(Level obj) {

    }

    @Override
    public void delete(Level obj) {

    }

    @Override
    public Level findById(Object id) {
        return null;
    }

    @Override
    public List<Level> findAll() {
        return entityManager.createQuery("select l from Level l", Level.class).getResultList();
    }
}
