package mx.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mx.dgtic.entity.Module;
import mx.dgtic.utils.HibernateUtil;

import java.util.List;

public class ModuleDao implements LearnHubDao<Module> {

    protected final EntityManager entityManager;

    public ModuleDao() {
        entityManager = HibernateUtil.getInstance().createEntityManager();
    }

    @Override
    public void insert(Module module) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(module);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public void update(Module module) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(module);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public void delete(Module module) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(module);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public Module findById(Object id) {
        return entityManager.find(Module.class, id);
    }

    @Override
    public List<Module> findAll() {
        return entityManager.createQuery("SELECT m FROM Module m", Module.class).getResultList();
    }
}

