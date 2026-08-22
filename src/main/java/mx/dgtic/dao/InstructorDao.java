package mx.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.dgtic.entity.Instructor;
import mx.dgtic.utils.HibernateUtil;

import java.util.List;


public class InstructorDao implements LearnHubDao<Instructor> {
    // Connection o Persistence Unit
    private final EntityManager entityManager;

    public InstructorDao() {
        entityManager = HibernateUtil.getInstance().createEntityManager();
    }

    // CRUD Operations
    public void insert(Instructor instructor) {
        // Insert into instructors
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(instructor);
            tx.commit();
        } catch (Exception ex) {
            if(tx.isActive()){
                tx.rollback();
            }
            throw ex;
        }
    }

    public void update(Instructor instructor) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(instructor);
            tx.commit();
        } catch (Exception ex) {
            if(tx.isActive()){
                tx.rollback();
            }
            throw ex;
        }
    }

    public void delete(Instructor instructor) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(instructor);
            tx.commit();
        } catch (Exception ex) {
            if(tx.isActive()){
                tx.rollback();
            }
            throw ex;
        }
    }

    public Instructor findById(Object id) {
        // SELECT * FROM instructors WHERE id = ?
        return entityManager.find(Instructor.class, id);
    }

    public List<Instructor> findAll() {
        // SELECT * FROM instructors
        return entityManager.createQuery("SELECT i FROM Instructor i", Instructor.class).getResultList();
    }

}

