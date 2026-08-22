package mx.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mx.dgtic.entity.Enrollment;
import mx.dgtic.utils.HibernateUtil;

import java.util.List;

public class EnrollmentDao implements LearnHubDao<Enrollment> {

    private final EntityManager entityManager;

    public EnrollmentDao() {
        entityManager = HibernateUtil.getInstance().createEntityManager();
    }

    @Override
    public void insert(Enrollment enrollment) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(enrollment);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public void update(Enrollment enrollment) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(enrollment);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public void delete(Enrollment enrollment) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(enrollment);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public Enrollment findById(Object id) {
        return entityManager.find(Enrollment.class, id);
    }

    @Override
    public List<Enrollment> findAll() {
        return entityManager.createQuery("SELECT e FROM Enrollment e", Enrollment.class).getResultList();
    }
}

