package mx.dgtic.repository;

import mx.dgtic.dao.CourseDao;
import mx.dgtic.entity.Course;

import java.util.List;

public class CourseRepository extends CourseDao {
    // Implementa operaciones de negocio para acceder a los datos


    public Course findCourseTitleById(Object id) {
        // NamedParam = :<NombreParam> >> SQL Injections | Script Injection
        var jpql = "SELECT c.id, c.title FROM Course c WHERE c.id = :id";
        return entityManager.createQuery(jpql, Course.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public int getTotalCourses() {
        return entityManager.createQuery("SELECT COUNT(c) FROM Course c", Long.class)
                .getSingleResult().intValue();
    }

    public List<Course> findByCategoryName(String categoryName) {
        return entityManager.createQuery(
                        "SELECT c FROM Course c WHERE c.category.name = :catName"
                ).setParameter("catName", categoryName)
                .getResultList();
    }

    public List<Course> findAllActiveCourses() {
        return null;
    }

    public void enableCourses() {

    }
}
