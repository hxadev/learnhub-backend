package mx.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.dgtic.entity.Category;
import mx.dgtic.utils.HibernateUtil;

import java.util.List;

public class CategoryDao implements LearnHubDao<Category> {
    // Connection o Persistence Unit
    protected final EntityManager entityManager;

    public CategoryDao() {
        entityManager = HibernateUtil.getInstance().createEntityManager();
    }

    // CRUD Operations
    public void insert(Category category) {
        // Session Start
        // Insert into categories
        EntityTransaction tx = entityManager.getTransaction();

        // Get Transaction - Preparar el metodo para ejecutar operaciones de alteracion de datos
        try {
            tx.begin();
            entityManager.persist(category);
            tx.commit();
        } catch (Exception ex) {
            if(tx.isActive()){
                tx.rollback();
            }
            throw ex;
        }finally {
            entityManager.close();
        }
        // Session End
    }

    public void update(Category category) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(category);
            tx.commit();
        } catch (Exception ex) {
            if(tx.isActive()){
                tx.rollback();
            }
            throw ex;
        }
    }

    public void delete(Category category) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.remove(category);
            tx.commit();
        } catch (Exception ex) {
            if(tx.isActive()){
                tx.rollback();
            }
            throw ex;
        }
    }

    public Category findById(Object id) {
        // SELECT * FROM categories WHERE id = ?
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        // SELECT * FROM categories
        // createQuery (JPL / HQL)
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

}
