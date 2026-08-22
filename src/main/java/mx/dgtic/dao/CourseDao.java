package mx.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mx.dgtic.entity.Course;
import mx.dgtic.utils.HibernateUtil;

import java.util.List;

public class CourseDao implements LearnHubDao<Course> {

    private final EntityManager entityManager;

    public CourseDao() {
        entityManager = HibernateUtil.getInstance().createEntityManager();
    }

    @Override
    public void insert(Course course) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(course);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public void update(Course course) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(course);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public void delete(Course course) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(course);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public Course findById(Object id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }
}

